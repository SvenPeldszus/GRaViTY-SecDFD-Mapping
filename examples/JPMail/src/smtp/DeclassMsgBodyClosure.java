package smtp;

import jif.lang.Closure;

public class DeclassMsgBodyClosure implements Closure { 
    final String msgBody; 

    public DeclassMsgBodyClosure(String msgBody) {
    		this.msgBody = msgBody;
    }

    // This returns a Ciphertext
    public Object invoke()  {
    		return this.msgBody;
    }
}
