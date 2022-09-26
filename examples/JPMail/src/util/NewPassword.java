package util;

import java.security.Principal;

import policy.JifPolicy;
import policy.PolicyStore;

public class NewPassword
{
	public static void main(String[] args) {
		Principal user = null;
		String mainPstr = "bono";
				
		if (args == null) return; 
		else if(args.length < 1) return;
		else {
			try {
				mainPstr = args[0];
			} catch (ArrayIndexOutOfBoundsException impossible) {}
		}

		// bootstrapping password
		try {
			if (mainPstr.equals("-"))
				if (args != null && args.length >= 2) {
					util.Password.setPassword(args[1], user);
					return;
				}
		} catch (NullPointerException ignore) {
		} catch (ArrayIndexOutOfBoundsException impossible) {}
				
		// presumes a real user
		PolicyStore policy = null;
		try {
			policy = JifPolicy.setupPolicy(mainPstr);
		} catch (SecurityException e) {}
		
		Principal mainP = (policy != null) ? policy.getPrincipal(mainPstr) : null;
		final Principal me = mainP;
		try {
			if (args != null) util.Password.setPassword(args[1], me);
		} catch (ArrayIndexOutOfBoundsException ignore) {}
    }
}