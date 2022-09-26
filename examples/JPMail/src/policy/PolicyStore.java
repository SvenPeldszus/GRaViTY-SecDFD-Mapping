package policy;

import java.security.Principal;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// another option is to store the label along with the Principal in the Set principals
// for example, we could have Principal addNewPrincipal(String name, label lb)
// which would store the Principal and its label in the PrincipalStore
// this would require some declassifications, because {P:} will dominate all the labels
// otherwise.

// P is the manager of the PrincipalStore
// All the principals in the Store are owned by P
// In order to get a principal, P must authorize the access and declassify the principal
// This should be OK in general
// We'll make a closure to enforce this policy: GetPrincipalClosure
// P should be a ManagerPrincipal if the Store is going to be properly protected

public class PolicyStore
{      
    final List principals;

    // we could restrict the principal to be a manager principal by using "instanceof"
    public PolicyStore()
    {
    		this.principals = new LinkedList();
    }

    // Similarly, it may be good to allow the name to be an arbitrary label and 
    // raise the security of the call accordingly; we could do this with another 
    // parameter which is a dynamic label

    // We don't use iterators here, because they have side-effects.
    // A simple loop avoids this problem

    // To be useful this must be called through a Closure with the Manager's authorization
    // Otherwise, it can only be called by the Manager

  
    /**
     * Returns the principal corresponding to name and declassifies it to lb
     * @param name The name of the principal to retrieve
     * @param lb The label at which the principal will be retrieved
     * @return the Principal at security level  which corresponds to name
     *         Should return <top> if there is no matching principal
     *         Currently it returns null, which is not good
     */
    public Principal getPrincipal(String name)
    {
		if (principals == null)
		    return null;
	
		// First get the principal from the Store
		Principal ret_p = null;
		int length = principals.size();
		for (int i = 0; i < length; i++) {
		    try {
				final PrincipalWrapper wrapper = (PrincipalWrapper)principals.get(i);
				
				if (wrapper != null) {
					if (wrapper.getName().compareTo(name) == 0) { // found it!
						ret_p = wrapper.getPrincipal(); // can only return it with sufficient confidentiality
						break;
				    }
				}
		    }
		    catch (IndexOutOfBoundsException impossible) {}
		    catch (NullPointerException impossible) {}
		    catch (ClassCastException e) {} // this shouldn't occur -- knock on wood
		}
		
		return ret_p;
    }

    /**
     * Returns the principal corresponding to name and declassifies it to lb
     * @param name The name of the principal to retrieve
     * @param lb The label at which the principal will be retrieved
     * @return the Principal at security level  which corresponds to name
     *         Should return <top> if there is no matching principal
     *         Currently it returns null, which is not good
     */
    public Principal getPrincipalSec(String name)
    {
		if (principals == null)
		    return null;
	
		// First get the principal from the Store
		Principal ret_p = null;
		int length = principals.size();
		for (int i = 0; i < length; i++) {
		    try {
				final PrincipalWrapper wrapper = (PrincipalWrapper)principals.get(i);
				
				if (wrapper != null) {
					if (wrapper.getName().compareTo(name) == 0) { // found it!
						ret_p = wrapper.getPrincipal(); // can only return it with sufficient confidentiality

						break;
				    }
				}
		    }
		    catch (IndexOutOfBoundsException impossible) {}
		    catch (NullPointerException impossible)  {}
		    catch (ClassCastException e) {}  // this shouldn't occur -- knock on wood
		}
		
		return ret_p;
    }

    // may need to adjust these labels
    // we need the side-effects and return-labels because of it.next() primarily
    // I think this is less than optimal
    // Similarly, it may be good to allow the name to be an arbitrary label and 
    // raise the security of the call accordingly
    /**
     * This takes a name
     * In future incarnations, it could take a public key or something more unique
     * than a name
     * @param name Merely a String representing the principal
     * @return whether the parameter is in the Principal Store
     */
    public boolean hasPrincipal(String name)
    {
		if (principals == null)
		    return false;
	
		boolean hasIt = false;
		
		int length = principals.size();
		for (int i = 0; i < length; i++) {
		    try {
				final PrincipalWrapper wrapper = (PrincipalWrapper)principals.get(i);
				
				if (wrapper != null) {
					if (wrapper.getName().compareTo(name) == 0) { // found it!
						hasIt = true;
						break;
				    }
				}
		    }
		    catch (IndexOutOfBoundsException impossible) {}
		    catch (NullPointerException impossible) {}
		    catch (ClassCastException e) {} // this shouldn't occur -- knock on wood
		}
		
		return hasIt;
    }

    public int size()
    {
		if (principals == null) return -1;
		else return principals.size();
    }

    // Need to be careful here.
    // shouldn't be able to add a principal unless the invariant holds
    // that p.name() == name
    // there may be a way to do this using authority and declassifying to check
    public void addPrincipal(Principal p, String name)
    {
		try {
		    if (principals != null)
				if (!(this.hasPrincipal(name))) {
				    final PrincipalWrapper wrapper = new PrincipalWrapper(p,name);
				    principals.add((Object)wrapper);
				}
		} catch (IllegalArgumentException impossible) {
		} catch (ClassCastException impossible) {}
    }
}
