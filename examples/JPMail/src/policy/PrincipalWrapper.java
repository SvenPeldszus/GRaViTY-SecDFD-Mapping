package policy;

import java.security.Principal;

public class PrincipalWrapper {
	final Principal p;
	final String name;

	// name and p.name() must be equal -- not sure how to enforce this
	public PrincipalWrapper(Principal p1, String name) {
		this.p = p1;
		this.name = name;
	}

	// It may make sense to store its original label and restore it at this point.
	public Principal getPrincipal() {
		return this.p;
	}

	public String getName() {
		return this.name;
	}

	/*
	 * Since the information that is returned by the equals() method will depend on
	 * information both from the comparison object <code>obj</code> and the fields
	 * of a class, this interface is parameterized on a label.
	 */
	public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (obj instanceof PrincipalWrapper) {
            try {            		
	            return this.getName().compareTo( ((PrincipalWrapper)obj).getName()) == 0;
		    } catch (ClassCastException impossible) {
		    } catch (NullPointerException e) { return false; }
        }
        return false;
    }
	
    public int hashCode()
    {
		int hash = -382389;
		return hash;
    }

	public String toString()
    {
    		return name;
    }
}
