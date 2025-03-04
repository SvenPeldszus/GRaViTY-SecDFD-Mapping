package jif.lang;

import java.util.HashMap;
import java.util.Map;

import crypto.DESClosure;
import crypto.RSAClosure;

/**
 * Utility methods for principals.
 * 
 * See the Jif source code, in lib-src/jif/lang/PrincipalUtil.jif
 */
public class PrincipalUtil {
    private static Map chainCache = new HashMap();

    /**
     * Returns true if and only if the principal p acts for the principal q. A
     * synonym for the <code>actsFor</code> method.
     */
    public static boolean acts_for(Principal p, Principal q) {
        return actsFor(p, q);
    }

    /**
     * Returns true if and only if the principal p acts for the principal q.
     */
    public static boolean actsFor(Principal p, Principal q) {
//   		System.out.println("PrincipalUtil: testing if " + (p!= null?p.name():"null") + " actsfor " + (q!=null?q.name():"null"));
        // anyone can act for the "null" principal
        if (q == null) return true;

        // if the two principals are ==-equal, or if they
        // both agree that they are equal to each other, then
        // we return true (since the acts-for relation is
        // reflexive).
        if (p == q) return true;
        if (q.equals(p) && p != null && p.equals(q)) return true;

        // try a simple test first
        if (q.delegatesTo(p)) return true;

        // try the cache
        PrincipalPair pp = new PrincipalPair(p, q);
        Principal[] chain = (Principal[])chainCache.get(pp);
        if (chain != null) {
            if (verifyChain(chain, p, q)) return true;
            // chain is no longer valid
            chainCache.remove(pp);
        }

        // try searching
        chain = findDelegatesChain(p, q);
        if (chain != null && verifyChain(chain, p, q)) {
            // cache the chain to avoid searching later.
            chainCache.put(pp, chain);
            return true;
        }

        // can't do anything more!
        return false;
    }

    /**
     * Search for a delegates-chain between p and q. An delegates-chain between
     * p and q is a Principal array <code>a</code> of length L such that
     * 
     * <pre>
     * 
     *  
     *       a[L-1] == q
     *       a[L-1] delegates to a[L-2]
     *       ...
     *       a[1] delegates to a[0]
     *       a[0] == p
     *     
     *  
     * </pre>. Thus, a valid delegate chain between p and q implies that p acts
     * for q.
     * 
     * @param p
     * @param q
     * @return A delegates-chain between p and q, or null if non can be found.
     */
    public static Principal[] findDelegatesChain(Principal p, Principal q) {
/*        System.out.print("findDelegatesChain(");
    		if (p == null) System.out.print("null, ");
    		else System.out.print(p.toString() + ", ");
    		if (q == null) System.out.println("null)");
    		else System.out.println(q.toString() + ")");
*/
    		// try the dumb things first.
        if (p == q) {
            Principal[] chain = new Principal[1];
            chain[0] = p;
            return chain;
        }
        if (q == null || (p != null && p.equals(q) && q.equals(p))) {
            Principal[] chain = new Principal[2];
            chain[0] = p;
            chain[1] = q;
            return chain;
        }

        // try searching upwards from q.
//        System.out.println("q.findChainUpto(p)");
        Principal[] chain = q.findChainUpto(p);
        if (chain != null) return chain;

        // try searching downards from p.
        if (p != null) {
            chain = p.findChainDownto(q);
            if (chain != null) return chain;
        }

        // have failed!
        return null;
    }

    public static Principal[] findDelegatesChain(Principal p, Principal q, Principal[] exclude) {
/*        System.out.print("findDelegatesChainX(");
    		if (p == null) System.out.print("null, ");
    		else System.out.print(p.toString() + ", ");
    		if (q == null) System.out.println("null)");
    		else System.out.println(q.toString() + ")");
    		System.out.print("Exclude = ");
    		for (int i = 0; i < exclude.length; i++)
    			System.out.print(exclude[i].toString() + " , ");
    		System.out.println("");
*/    		

    		// try the dumb things first.
        if (p == q) {
            Principal[] chain = new Principal[1];
            chain[0] = p;
            return chain;
        }
        if (q == null || (p != null && p.equals(q) && q.equals(p))) {
            Principal[] chain = new Principal[2];
            chain[0] = p;
            chain[1] = q;
            return chain;
        }

        // try searching upwards from q.
//        System.out.println("q.findChainUptoX(p)");
        Principal[] chain = q.findChainUpto(p,exclude);
        if (chain != null) return chain;

        // try searching downards from p.
        if (p != null) {
            chain = p.findChainDownto(q);
            if (chain != null) return chain;
        }

        // have failed!
        return null;
    }
    
    /**
     * Verify that the chain is a valid delegates-chain between p and q. That
     * is, q == chain[n], chain[n] delegates to chain[n-1], ..., chain[0] == p,
     * i.e., p acts for q.
     *  
     */
    public static boolean verifyChain(Principal[] chain, Principal p,
            Principal q) {
        if (chain == null || chain.length == 0) return false;
        if (chain[0] != p || chain[chain.length - 1] != q) return false;

        // now go through the chain and check it
        for (int i = 0; i < chain.length - 1; i++) {
            // either i+1 has to be null, or i+1 has to delegate to i
            if (chain[i + 1] != null && !chain[i + 1].delegatesTo(chain[i])) {
                return false;
            }
        }
        return true;
    }

    private static class PrincipalPair {
        final Principal p;

        final Principal q;

        PrincipalPair(Principal p, Principal q) {
            this.p = p;
            this.q = q;
        }

        public boolean equals(Object o) {
            if (o instanceof PrincipalPair) {
                PrincipalPair that = (PrincipalPair)o;
                return (this.p == that.p || (this.p != null && that.p != null
                        && this.p.equals(that.p) && that.p.equals(this.p)))
                        && (this.q == that.q || (this.q != null
                                && that.q != null && this.q.equals(that.q) && that.q
                                .equals(this.q)));

            }
            return false;
        }

        public int hashCode() {
            return (p == null ? -4234 : p.hashCode())
                    + (q == null ? 23 : q.hashCode());
        }
    }

    public static boolean equivalentTo(Principal p, Principal q) {
        return actsFor(p, q) && actsFor(q, p);
    }
  
    /**
     * returns the null principal, the principal that every other principal can
     * act for.
     */                
    public static Principal nullPrincipal() {
        return null;
    }

	public static Closure authorize(java.security.Principal object, Closure dc, Closure rsaClo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static java.security.Principal[] findDelegatesChain(java.security.Principal p, java.security.Principal s,
			java.security.Principal[] exclude) {
		// TODO Auto-generated method stub
		return null;
	}
    
}