/* Jif poker - an implementation of mental poker protocol in Jif
 * (C) 2005 Aslan Askarov
 */
package util;

public class DeclassifyHelper {
    
    // let noone instantiate this class.
    private DeclassifyHelper() {
    }
    
    
/*    public static Digest declassifyDigest(Digest[] x1):
    where caller(P){
        Digest[] x = declassify (x1, );
        if (x == null) return null;
        
        byte[] ba = x.toByteArray();
        byte[] bb = declassifyByteArray(ba);
        return new Digest (bb);
           
    }
*/    
    public static byte[] declassifyByteArray(byte[] x)
	 {
		if (x == null) return null;

		int t = x.length;
		byte[] y = new byte[t];
		try {
			for (int i = 0; i < t; i++)
				y[i] = (x[i]);
			return y;
		} catch (ArrayIndexOutOfBoundsException ignored) {
			return null;
		}
	}
    
    public static byte[] upgradeByteArray(byte[] x1) {
		byte[] x = x1;
		if (x == null) return null;

		int t = x.length;
		byte[] y = new byte[t];
		try {
			for (int i = 0; i < t; i++)
				y[i] = x[i];
			return y;
		} catch (ArrayIndexOutOfBoundsException ignored) {
			return null;
		}
	}
    
    public static int[] declassifyIntArray(int[] x) {
		if (x == null) return null;

		int t = x.length;
		int[] y = new int[t];
		try {
			for (int i = 0; i < t; i++)
				y[i] = (x[i]);
			return y;
		} catch (ArrayIndexOutOfBoundsException ignored) {
			return null;
		}
	}
    
/*    public static DataFieldAttribute declassifyAttribute(
    DataFieldAttribute[] attrib1) where caller(P) {
        DataFieldAttribute[] attrib = declassify (attrib1, );
        try {
            if (attrib instanceof EncryptedCardVector[]) {
                return declassifyEncCardVector((EncryptedCardVector[]) attrib);
            } else if (attrib instanceof CardVector[] ) {
                return declassifyCardVector((CardVector[]) attrib);
            } else if (attrib instanceof BigIntVector[]) {
                return declassifyBigIntVector((BigIntVector[]) attrib);
            } else if (attrib instanceof PHIntVector[]) {
                return declassifyPHIntVector((PHIntVector[]) attrib);
            } else if (attrib instanceof PHInteger[]) {
                return declassifyPHInteger((PHInteger[]) attrib);
            } else if (attrib instanceof DABigInteger[]) {
                return declassifyBigInt((DABigInteger[]) attrib);
            } else if (attrib instanceof Digest[]) {
                return declassifyDigest((Digest[]) attrib);
            }
        } catch (ClassCastException ignored) {
        }
        return null;        
    }
*/    
/*    public static DAVector declassifyDAVector (
    DAVector[] x1) where caller(P) {
        DAVector [] x = declassify(x1, );
        if (x == null) return null;
        
        int t = declassify (x.size(), );
        DAVector y = new DAVector();
        
        y.ensureCapacity(t);
        for (int i = 0; i < t; i++) {
            try {
                DataFieldAttribute[] attrib  = (DataFieldAttribute[]) x.get(i);
                declassify () 
                    y.add(declassifyAttribute(attrib));
            } catch (IndexOutOfBoundsException ignored) {
            } catch (ClassCastException ignored) {
            }
        }
        return y;
    }
    
    
    public static EncryptedCardVector   declassifyEncCardVector (
    EncryptedCardVector[] x1)  {
        EncryptedCardVector [] x = declassify (x1, );
        if (x == null) return null;
        PHIntVector [] v = x.getValueVector();
        PHIntVector  u = declassifyPHIntVector(v);
        try {
           return new EncryptedCardVector(u);
        } catch (IllegalArgumentException ignored) {
           return null;
        }
    }
    
    public static EncryptedCardVector []  upgradeEncCardVector (
    EncryptedCardVector  x) {
        if (x == null) return null;
        PHIntVector  v = x.getValueVector();
        PHIntVector [] u = upgradePHIntVector(v);
        try {
            return new EncryptedCardVector [](u);
        } catch (IllegalArgumentException ignored) {
            return null;
        }
    }
    
    public static CardVector   declassifyCardVector (
    CardVector[] x1)  {
        CardVector [] x = declassify (x1, );
        if (x == null) return null;
        BigIntVector [] v = x.getValueVector();
        BigIntVector  u = declassifyBigIntVector(v);
        try {
           return new CardVector(u);
        } catch (IllegalArgumentException ignored) {
           return null;
        }
    }
    
    
    public static CardVector[] upgradeCardVector (
        CardVector x) {
        if (x == null) return null;
        BigIntVector  v = x.getValueVector();
        BigIntVector [] u = upgradeBigIntVector(v);
        try {
            return new CardVector[](u);
        } catch (IllegalArgumentException ignored) {
            return null;
        }
    }
    
    
    public static PermutationMatrix 
    declassifyMatrix(PermutationMatrix[] x1) where caller(P) {
        PermutationMatrix[] x = declassify(x1, );
        if (x == null) return null;        
        ArrayList[] m = declassify(x.getMatrix(), );
        if (m == null) return null;
        
        int t = declassify(m.size(),);
        
        
        ArrayList y = new ArrayList();
        y.ensureCapacity(t);
        
        for (int i = 0; i < t; i++){
            try {
                BigIntVector[]rowi = (BigIntVector[])m.get(i);
                declassify ()
                    y.add(declassifyBigIntVector(rowi));
            } catch (IndexOutOfBoundsException ignored) {
            } catch (ClassCastException ignored) {
            }
        }
        
        try {
            return new PermutationMatrix(y);
        } catch (IllegalArgumentException ignored){
            return null;
        }
    }
    
    public static BigIntVector declassifyBigIntVector (
    BigIntVector [] x1)  {
        BigIntVector [] x = declassify (x1, );
        if (x == null) return null;
        
        int t = declassify (x.size(), );
        BigIntVector y = new BigIntVector();
        y.ensureCapacity(t);
        
        for (int i = 0; i < t; i++) {
            try {
                DABigInteger[] big = x.getBI(i);
                declassify () y.add(declassifyBigInt(big));
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return y;
    }
    
    
    public static BigIntVector[] upgradeBigIntVector (
    BigIntVector x): {
        if (x == null) return null;
        int t = x.size();
        BigIntVector[] y = new BigIntVector[]();
        y.ensureCapacity(t);
        for (int i = 0; i < t; i++) {
            try { 
                DABigInteger big = x.getBI(i);
                y.add(upgradeBigInt(big));
            } catch (IndexOutOfBoundsException ignored) {
            }
        } 
        return y;
    }
    
    public static PHIntVector declassifyPHIntVector (
    PHIntVector [] x1) where caller(P) {
        PHIntVector [] x = declassify (x1, );
        if (x == null) return null;
        int t = declassify (x.size(), );
        
        PHIntVector  y = new PHIntVector  ();
        y.ensureCapacity(t);
        for (int i = 0; i < t; i++) {
            try {
                PHInteger[] phi = x.getPHI(i);
                // At this point PC gets incremented!!!
                // That's why we apply PC downgrading
                declassify () y.add(declassifyPHInteger(phi));
               
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return y;
    }
    
    
    public static PHIntVector[] upgradePHIntVector(
    PHIntVector  x){
        if (x == null) return null;
        int t = x.size();
        PHIntVector[] y = new PHIntVector []();
        y.ensureCapacity(t);
        for (int i = 0; i < t; i++) {
            try {
                PHInteger phi = x.getPHI(i);
                y.add(upgradePHInteger(phi));
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return y;
    }
    
    public static PHInteger  declassifyPHInteger (
    PHInteger[] x1) where caller(P) {
        PHInteger [] x = declassify (x1, );
        if (x == null) return null;
        int t = declassify (x.size(), );
        ArrayList  y = new ArrayList();
        y.ensureCapacity(t);
        
        for (int i = 0; i < t; i++) {
            try {
                y.add(declassifyBigIntPair(x.getBigIntPair(i)));
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return new PHInteger(y);
    }
    
    public static PHInteger[] upgradePHInteger(
    PHInteger x) {
        if (x == null) return null;
        int t = x.size();
        ArrayList [] y = new ArrayList[]();
        y.ensureCapacity(t);
        for (int i = 0; i < t; i++) {
            try {
                y.add(upgradeBigIntPair(x.getBigIntPair(i)));
            } catch (IndexOutOfBoundsException ignored) {
            }
        } 
        return new PHInteger[](y);
    }
    
    
    
    public static BigIntPair  declassifyBigIntPair(
    BigIntPair[] x1) where caller(P) {
        BigIntPair[] x = declassify (x1, );
        if (x == null) return null;
        
        BigIntPair y = new BigIntPair (
            declassifyBigInt(x.getX()), declassifyBigInt(x.getY()));
        return y;
    }
    
    
    public static BigIntPair[] upgradeBigIntPair(
    BigIntPair x) {
        if (x == null) return null;
        BigIntPair[] y = new BigIntPair [](
            upgradeBigInt(x.getX()), upgradeBigInt(x.getY()));
        return y;
        
    }
    
    
    public static DABigInteger declassifyBigInt(DABigInteger[] x1)
    where caller(P) {
        DABigInteger[] x = declassify (x1, );
        if (x == null) return null;
        java.math.BigInteger y = declassify (x.getValue(), );
        try {
            return new DABigInteger(y);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    
    
    public static DABigInteger[] upgradeBigInt(DABigInteger x): {
        if (x == null) return null;   
        java.math.BigInteger y = x.getValue();
        try {
            return new DABigInteger[](y);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
*/    
    

}


