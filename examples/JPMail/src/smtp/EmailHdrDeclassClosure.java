package smtp;

import jif.lang.Closure;
import pop3.JPMailMessage;

public class EmailHdrDeclassClosure implements Closure { 
	final JPMailMessage msg;
	
	// must make sure we're not declassifying the body -- originalBody should be null
    public EmailHdrDeclassClosure(JPMailMessage msg) {
    		//this.msg = msg != null ? (msg.getOriginalBody() == null ? null : msg) : null;
    		this.msg = msg;
    }

    // encrypt with public key and declassify iff rcptP <= P
    public Object invoke()  {
		return msg;
    }
}
