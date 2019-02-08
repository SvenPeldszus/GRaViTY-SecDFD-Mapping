package jif.runtime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.security.PrivateKey;

/**
 * The runtime interface between Jif programs and the underlying system.
 */
public class Runtime {
    
    /**
     * Gets a <code>Runtime</code> object parameterized with the
     * principal <code>p</code>.
     */
    public static Runtime getRuntime() throws SecurityException {
        //check if the current user can act for p
        return new Runtime();
    }

    /**
     * Opens a file output stream to write a file with the specific <code>name</code>.
     *
     * @param name     the file name
     * @param append   if true, then bytes will be written to the end of the file
     *                 rather than the beginning
     * @param L        the label parameter of the resulting <code>FileOutputStream</code>
     *
     * @exception  FileNotFoundException
     *      if the file exists but is a directory rather than a regular file,
     *      does not exist but cannot be created, or cannot be opened for any
     *      other reason.
     *
     * @exception  SecurityException
     *      if <code>l</code> is unable to relabel to the Jif label derived from
     *      the ACL of the file.
     */
    public FileOutputStream openFileWrite(String name, boolean append)
            throws IOException, SecurityException {
        File f = new File(name);
        boolean existed = f.exists();

        FileOutputStream fos = new FileOutputStream(name, append);

        if (!existed) {
            fos.flush();
            //            FileSystem.setPolicy(name, (PrivacyPolicy)L.policy());
        }
        return fos;
    }

    /** Opens a file input stream for reading from the file with the specific
     *  <code>name</code>.
     *
     *  @param name     the file name
     *  @param L        the the label parameter of the resulting <code>FileInputStream</code>
     *
     *  @exception  SecurityException
     *      if <code>l</code> is less restrictive than the Jif label derived from
     *      the ACL of the file.
     */
    public FileInputStream openFileRead(String name)
            throws FileNotFoundException, SecurityException {
       return new FileInputStream(name);
    }

    /**
     * Gets the standard error output.
     * The output channel is parameterized by <code>l</code>.
     */
    public PrintStream stderr() {
        return System.err;
    }

    /**
     * Gets the standard output.
     * This output channel is parameterized by <code>l</code>.
     */
    public PrintStream stdout() {
            return System.out;
    }

    /**
     * Gets the standard input.
     * This input channel is parameterized by <code>l</code>.
     */
    public InputStream stdin() {
       return System.in;
    }

    /**
     * Get the standard output parameterized by the default label, which
     * has only one reader: the principal of this <code>Runtime</code> object.
     */
    public PrintStream out() {
        return System.out;
    }

    /**
     * Get the standard input parameterized by the default label, which
     * has only one reader: the principal of this <code>Runtime</code> object.
     */
    public InputStream in() {
        return System.in;
    }

    /**
     * Get the standard error output parameterized by the default label, which
     * has only one reader: the principal of this <code>Runtime</code> object.
     */
    public PrintStream err() {
        return System.err;
    }

    public static String currentUser() {
        if (_nativeOK) return currentUserImpl();
        return null;
    }

    private static native String currentUserImpl();

    public static Object[] arrayDeepClone(Object[] a) {
        if (a == null) return null;
        Object[] c = a.clone();
        for (int i = 0; i < a.length; i++) {
            Object o = a[i];
            if (o != null && o.getClass().isArray()) {
                if (o.getClass().getComponentType().isPrimitive()) {
                    // o is of type e.g., int[]. Need to clone it.
                    int length = Array.getLength(o);
                    o = Array.newInstance(o.getClass().getComponentType(),
                            length);
                    System.arraycopy(a[i], 0, o, 0, length);
                } else {
                    // o i of type C[]
                    o = arrayDeepClone((Object[]) o);
                }
            }
            c[i] = o;
        }
        return c;
    }

    private static boolean _nativeOK = true;

    public static void loadRuntimeLibrary() {
        if (_nativeOK) {
            try {
                System.loadLibrary("jifrt");
            } catch (UnsatisfiedLinkError ule) {
                // fail, but continue with warning
                _nativeOK = false;
                System.err.println(ule.getLocalizedMessage());
            } catch (SecurityException se) {
                _nativeOK = false;
                System.err.println(se.getLocalizedMessage());
            }
        }
    }

    static {
        loadRuntimeLibrary();
    }

	public PrivateKey getPrivateKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Runtime getRuntime(String keystoreFilename, char[] keystorePwd, String trustedCAfilename) {
		// TODO Auto-generated method stub
		return null;
	}
}
