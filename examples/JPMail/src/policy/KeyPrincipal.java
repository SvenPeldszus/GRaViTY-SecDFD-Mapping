package policy;
// Key principal, contains public key (and possibly a private key)

// equality is based on name equality and public key equality

import java.security.PublicKey;

import jif.lang.AbstractPrincipal;

import java.security.Principal;
import java.security.PrivateKey;

public class KeyPrincipal extends AbstractPrincipal {
	private final PublicKey publicKey;
	private final char[] keystorePwd;
	final String keystoreFilename;
	final String trustedCAfilename;

	public KeyPrincipal(String name) {
		super(name);
		this.publicKey = null;
		this.keystorePwd = null;
		this.keystoreFilename = null;
		this.trustedCAfilename = null;
	}

	public KeyPrincipal(String name, PublicKey pubKey) {
		super(name);
		this.publicKey = pubKey;
		this.keystorePwd = null;
		this.keystoreFilename = null;
		this.trustedCAfilename = null;
	}

	public KeyPrincipal(String name, PublicKey pubKey, char[] pwd, Principal user) {
		super(name);
    		this.publicKey = pubKey;
    		char[] _pwd = (pwd);
    		int len = _pwd != null ? (_pwd.length) : 0;
    		this.keystoreFilename = "certs/.keystore";  // temporary solution; eventually pass this in
    		this.trustedCAfilename = "certs/cacert.pem";
    		this.keystorePwd = new char[len];
    		try {
	    		for (int i = 0; i < len; i++)
	    			this.keystorePwd[i] = (_pwd[i]);
    		} catch (ArrayIndexOutOfBoundsException e) {
    		} catch (NullPointerException e) {} // due to array accesses
    }

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public PrivateKey getPrivateKey() throws SecurityException {
		final jif.runtime.Runtime runtime = jif.runtime.Runtime.getRuntime(this.keystoreFilename, this.keystorePwd, this.trustedCAfilename);
		return runtime != null ? runtime.getPrivateKey() : null;
    	}
    	
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof KeyPrincipal) {
            return equals((KeyPrincipal)o);
        }
        return false;
    }

	public char[] getKeystorePwd() {
		return this.keystorePwd;
	}

	public String getKeystoreFilename() {
		return this.keystoreFilename;
	}

	public String getTrustedCAfilename() {
		return this.trustedCAfilename;
	}

	public boolean equals(KeyPrincipal p) {
		if (p == null)
			return false;
		else {
			/*
			 * try { byte[] pubKeybits1 = this.publicKey.getEncoded(); byte[] pubKeybits2 =
			 * this.publicKey.getEncoded(); if (pubKeybits1.length != pubKeybits2.length)
			 * return false; for (int i = 0; i < pubKeybits1.length; i++) if (pubKeybits1[i]
			 * != pubKeybits2[i]) return false;
			 */
			return ((AbstractPrincipal) p).equals(this);
			/*
			 * } catch (NullPointerException e) { return false; } catch
			 * (ArrayIndexOutOfBoundsException impossible) { return false; }
			 */ }
	}

	@Override
	public String getName() {
		return super.name();
	}
}
