/* *****************************************************************************
*
*   FILE          :MailSenderCrypto.jif
*   Project       :JPmail
*   Description   :Main file for sending email using SMTP
*				  
*   Last Modified :Mon Apr 10 15:27:52 EDT 2006
*
*  Copyright (c) 2006 The Pennsylvania State University
*  Systems and Internet Infrastructure Security Laboratory
*
******************************************************************************/
package smtp;

import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.security.Principal;
import java.io.PrintStream;
//import javax.mail.internet.MailDateFormat;
import javax.net.SocketFactory;

import jif.lang.PrincipalUtil;
//import javax.net.ssl.SSLSocketFactory;
import jif.net.JifSocketFactory;

import policy.PolicyStore;
import policy.JifPolicy;
import pop3.JPMailMessage;
import pop3.MimeMailMessage;

/**
 * @author phicks
 *
 */
public class MailSenderCrypto {
    /*== Class Global Data ==========================================*/
    final private String mailhost, username;
    final private String emailAddress;
    final private byte[] password;  // user byte array, because Strings can't be destroyed
    final private int mailport;
    final private boolean isSSL;

    final private Principal SocketP;
    private Socket sock;
    private BufferedReader in;
    private BufferedOutputStream out;
    protected boolean isConnected;

    public static final String SMTP_PORT = "25"; // default POP3 port
    public static final String SSMTP_port = "465"; // default POP3 SSL port
    private static final byte[] CRLF = { (byte)'\r', (byte)'\n' };

    final private PolicyStore policy;
    final private Principal debugP; // only needed for passing the output stream around--hopefully just for debugging.
    final PrintStream debug;

    /** Constructor
     * @param host host name
     * @param name user name
     * @param pass password (should be high security)
     * @param port port number
     * @param ssl whether it is an SSL connection
     */
    MailSenderCrypto(String host, String name, String emailAddress, byte[] pass, int port, 
    				boolean ssl, PolicyStore policy, Principal debugP, PrintStream debug)
    {
    		this.emailAddress = emailAddress;
		this.policy = policy;
		this.debugP = debugP;
		this.debug = debug;
		mailhost = host;
		username = name;
		password = pass;
		mailport = port;
		isSSL = ssl;
		isConnected = false;
		if (!isSSL) {
			SocketP = null;  // this makes it public
//			SocketL = new label{};
		}
		else {
			SocketP = null; //Owner;  // Could make it Server-level with SSL enabled; but Owner works for now
//			SocketL = new label{Owner:};
		}
		isConnected = false;
    }

    /** establishes connection if one does not already exist
     * side-effects: changes userString, passString, isConnected, opens a socket, reads from and writes to the socket
     * @throws IOException
     */
    public boolean connect() throws IOException
    {
		// {
		if (true) {
			BufferedReader in = this.in; // use locals so NPE-analysis works
			BufferedOutputStream out = this.out;
			
			String response = "";
			SocketFactory socketFactory = new JifSocketFactory();  // it's not SSL so it should be considered public
					
			if (debug != null) {
			    debug.println("mailhost is: " + mailhost);
			    debug.println("username is: " + username);
			    try {
			    		debug.println("Pass is: ");// + new String(password));
			    	} catch (NullPointerException npe) {}
			}
			
			// No need to connect
			if (isConnected) {
			    return true;
			}
/*			else if (username == null || password == null) {
				return false;
			}
*/		
			// Handle SSL properly
			// Need to set SocketP appropriately
			//		if (isSSL) {
			//		    socketFactory = SSLSocketFactory[].getDefault();
			//		} else {
			//		    socketFactory = SocketFactory[].getDefault();
			//		}
			
			final Socket sock = socketFactory.createSocket(mailhost, mailport);
			this.sock = sock;
			
			// configure socket io streams
			if (sock != null) {
				if (debug != null) debug.println("getting I/O sockets...");
					
			    in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			    try {
			    		out = new BufferedOutputStream(sock.getOutputStream());
			    	} catch (IllegalArgumentException ignore) {} // this shouldn't happen
			    this.in = in;	// save new open Socket in this's data
			    this.out = out;	// save new open Socket in this's data
			}
			else if (debug != null) debug.println("Socket is null for some reason.");
			
			// log in
			if (in != null) 
				response = in.readLine(); // should be the welcome banner
			if (debug != null) debug.println("Initial response:\n" + response);
			
			// helo mail.cse.psu.edu
			// 250 mail.cse.psu.edu
			if (in != null && out != null) {
			    if (debug != null) debug.println("Sending:\nehlo " + mailhost);
			    response = sendCmd("ehlo " + mailhost, "250");            // send "ehlo" greeting and get response
			    if (debug != null) debug.println("Response:\n" + response);


/*	    } else if (supportsAuthentication("DIGEST-MD5") &&
		    (md5 = getMD5()) != null) {
*/
			    DigestMD5 md5 = null;
			    try {
			    		md5 = new DigestMD5();
			    	} catch (java.security.NoSuchAlgorithmException e) {if (debug != null) debug.println("No such algorithm for MessageDigest.");
			    	} catch (java.security.NoSuchProviderException e) {if (debug != null) debug.println("No such provider for MessageDigest."); }
			    	if (md5 == null) {if (debug != null) debug.println("MD5 didn't initialize for some reason.");}
			    	else if (debug != null) debug.println("Got MD5!");
			    	
			    if (debug != null) debug.println("Sending AUTH DIGEST-MD5");
				String resp = sendCmd("AUTH DIGEST-MD5", "334");
			    if (debug != null) debug.println("Response:\n" + resp);
				try {
				    if (resp != null && resp.length() >= 3 && resp.substring(0,3).equals("334")) {
				    		String passwd = null;
				    		try {
				    			passwd = new String(password);
				    		} catch (NullPointerException npe) {}
				    		
				    		if (debug!= null) debug.println("...Converted password to String...");
				    		
				    		if (md5 == null) if (debug != null) debug.println("What happened?!");
				    		
				    		final byte[] b = md5.authClient(mailhost, username, passwd,
								    //getSASLRealm(), 
								    null, resp, debug, debugP);
						if (debug != null) debug.println("--past authClient--");
						if (b == null) {if (debug != null) debug.println("ERROR: authClient returned null");}
						
						String br = null;
						try {
							br = new String(b);
						} catch (NullPointerException ignore) {}
						if (debug != null) debug.println("Sending: " + br);
						resp = sendCmd(b,"334");
						if (debug != null) debug.println("Response: " + resp);
						
						// presume server is ok
				    		if (debug != null) debug.println("Sending NULL");
				    		resp = sendCmd(new byte[0],"235");
				    		if (debug != null) debug.println("NULL Response: " + resp);

/*						if (resp != null && resp.length() >= 3 && resp.substring(0,3).equals("334")) { // client authenticated by server
						    if (debug != null) debug.println("AUTHENTICATING SERVER...");
						    boolean respBool = md5.authServer(resp);//, debug, debugP); // CAUSED A WEIRD LINELESS ERROR
						    if (respBool) {
						    		if (debug != null) debug.println("Authenticating server failed...");
								// server NOT authenticated by client !!!
								resp = null;
						    } else {
								// send null response
						    		if (debug != null) debug.println("Authenticating server succeeding...send NULL");
						    		resp = sendCmd(new byte[0],"235");
						    		if (debug != null) debug.println("NULL Response: " + resp);
						    }
						}
*/				    }
				} catch (NullPointerException ex) {	// should never happen, ignore
				    if (debug != null) debug.println("DEBUG SMTP: DIGEST-MD5: NullPointerException " + (ex != null ? ex.toString() : ""));
				} catch (StringIndexOutOfBoundsException ex) {	// should never happen, ignore
				    if (debug != null) debug.println("DEBUG SMTP: DIGEST-MD5: StringIndexOutOfBoundsException " + (ex != null ? ex.toString() : ""));
/*				} finally {
				    if (resp != 235) {
					closeConnection();
					return false;
				    }
				}
*/			    // do plain authentication
			    //if (supportsAuthentication("PLAIN")) {
				// XXX - could use "initial response" capability
/*				String resp = sendCmd("AUTH PLAIN","334");
				try {
					if (resp != null && resp.length() >= 3 && resp.substring(0,3).compareTo("334") == 0) {
					    ByteArrayOutputStream bos = new ByteArrayOutputStream();
					    OutputStream b64os = new BASE64EncoderStream(bos, Integer.MAX_VALUE);
						// send "<NUL>user<NUL>passwd"
						// XXX - we don't send an authorization identity
						b64os.write(0);
						b64os.write(username == null ? null : username.getBytes());
						b64os.write(0);

// DECLASSIFICATION need to declassify password to send it--this is why we should use SSL sockets!!						
						int len = declassify(password == null ? 0 : password.length,);
						final byte[] pw = new byte[len];
						try {
							for (int i = 0; i < len; i++)
								pw[i] = declassify(password[i],);
						} catch (ArrayIndexOutOfBoundsException ignore) {
						} catch (NullPointerException ignore) {}
						
						b64os.write(pw);
						b64os.flush(); 	// complete the encoding
			
						resp = sendCmd(bos.toByteArray(),"235");
					}
					else return false;
				} catch (StringIndexOutOfBoundsException ex) { // should never happen, ignore
				} catch (IOException ex) {	// should never happen, ignore
				} catch (NullPointerException impossible) { // because of the substring.compareTo
*/				} finally {
					try {
						if (resp != null && resp.length() >= 3 && resp.substring(0,3).compareTo("235") != 0) {
				    			close();
				    			return false;
				    		}
					} catch (StringIndexOutOfBoundsException ex) { // should never happen, ignore
					} catch (NullPointerException impossible) {} // because of the substring.compareTo
				}
			}
			else if (debug != null) debug.println("socket I/O is null for some reason");
							
			isConnected = true;
			return true;
		}
		return false;
    }
    
    /** closes the connection
     * @throws IOException
     */
    public void close() throws IOException
    {
    		// could send "exit" here to be nice to the SMTP port
    		try {
    			sock.close();
    		}
    		catch (NullPointerException e) {} //ignore
 		isConnected = false;
    }
    
	
	/**
	 * sends command and expects a 250 response
	 * @param cmd The command to send (should be sent by owner -- convert to Socket's principal?
	 * @return The last response String from the Server
	 */ 
	public String sendCmd(String cmd) throws IOException
	{
		return this.sendCmd(cmd,"250");
	}
	
	/**
	 * sends command as a byte array and expects the given response
	 * @param cmd The command to send as a byte array (should be sent by owner -- convert to Socket's principal?)
	 * @param resp The number of the response expected, e.g. "250" is the default.
	 * @return The last response String from the Server
	 */ 
	public String sendCmd(byte[] cmd, String resp) throws IOException
	{
		BufferedReader in = this.in; // use locals so NPE-analysis works
		BufferedOutputStream out = this.out;

		// send command to socket
		if (out != null) {
			try {
				String cmdStr= new String(cmd);
				 if (debug != null && cmd != null) debug.println(cmdStr);
			}
			catch (NullPointerException impossible) {} // from "new String(cmd)"
		    out.write(cmd);
		    out.write(CRLF);
		    out.flush();
		}
		   
		// read response
		String response = null;
		if (in != null) { // TODO: at some point, we'll want to parse this
			do {
				response = in.readLine();
				 if (debug != null) debug.println(response);
			} while(isNotLastLine(response));
		}
		
		// check response against expected response
		if (response != null) {
		    try {
				if (response.substring(0, 3).compareTo(resp) != 0) {
				     if (debug != null) debug.println("Error: response is: " + response);
				}
		    }
		    catch (StringIndexOutOfBoundsException e) {}
		    catch (NullPointerException e) {}
		}
		else  if (debug != null) debug.println("response = NULL");
		
		return response;
    }

	/**
	 * sends command and expects the given response
	 * @param cmd The command to send as a String (should be sent by owner -- convert to Socket's principal?
	 * @param resp The number of the response expected, e.g. "250" is the default.
	 * @return The last response String from the Server
	 */ 	
    public String sendCmd(String cmd, String resp) throws IOException
    {
		BufferedReader in = this.in; // use locals so NPE-analysis works
		BufferedOutputStream out = this.out;

		// send command to socket
		if (out != null && cmd != null) {
			 if (debug != null) debug.println(cmd);
		    out.write(cmd.getBytes());
		    out.write(CRLF);
		    out.flush();
		}
		   
		// read response
		String response = null;
		if (in != null) { // TODO: at some point, we'll want to parse this
			do {
				response = in.readLine();
				 if (debug != null) debug.println(response);
			} while(isNotLastLine(response));
		}
		
		// check response against expected response
		if (response != null) {
		    try {
				if (response.substring(0, 3).compareTo(resp) != 0) {
				     if (debug != null) debug.println("Error: response is: " + response + ", but expected " + resp);
				}
		    }
		    catch (StringIndexOutOfBoundsException e) {}
		    catch (NullPointerException e) {}
		}
		else  if (debug != null) debug.println("response = NULL");
		
		return response;
    }
    
    // tests if the <code>line</code> is an intermediate line according to SMTP
    private boolean isNotLastLine(String line) {
        boolean ret = true;
        try {
        		ret = line != null && line.length() >= 4 && line.charAt(3) == '-';
        	}
        	catch (StringIndexOutOfBoundsException impossible) {}
        	return ret;
    }
    
    /** 
     * begins the body of a mail message
     */
    public void beginBody() throws IOException
    {
		BufferedOutputStream out = this.out;

		if (out != null) {
		    out.write(CRLF); // body separated from header fields by a <CR><LF>
		    out.flush();
		}
    }

   /** 
    * ends the body of a mail message
    */        
    public String endBody() throws IOException
    {
    		// we could also remember and do something with the queue number if we wanted to here.
    		return this.sendCmd("\r\n.","250");	// the last CRLF is provided by sendCmd
    }
    
    /**
     * sends a field in a mail header
     * @param field simply the field to send (e.g. "From", "To", "X-Jif-Label")
     * @param arg the argument given to the field (e.g. "bonifacehicks@catholic.org", "bono")
     */
    public void sendField(String field, String arg) throws IOException
    {
		BufferedOutputStream out = this.out;

		if (out != null && field != null && arg != null) {
			final String colon = ": ";
		    out.write(field.getBytes());
		    out.write(colon.getBytes());
		    out.write(arg.getBytes());
		    out.write(CRLF);
		    out.flush();
		}
    }
    		
    	/**
    	 * sends text, e.g. for the body of a message, ending it with CRLF
    	 * @param bodyText the text to send
    	 */
    public void sendText(String bodyText) throws IOException
    {
		BufferedOutputStream out = this.out;

		if (out != null && bodyText != null) {
		    out.write(bodyText.getBytes());
		    out.write(CRLF);
		    out.flush();
		}
    }

    	/**
    	 * sends text, e.g. for the body of a message, ending it with CRLF
    	 * @param bodyText the text to send as a byte array (useful especially for crypto)
    	 */
    public void sendText(byte[] bodyText) throws IOException
    {
		BufferedOutputStream out = this.out;

		if (out != null) {
		    out.write(bodyText);
		    out.write(CRLF);
		    out.flush();
		}
    }
    
    public void sendMessage(MimeMailMessage msg)
    {
		BufferedReader in = this.in; // use locals so NPE-analysis works
	
		if (!isConnected) {
		    return;//throw new IOException("not connected.");
		}
		
		try {
			if (msg != null) {
				// generate the "envelope"
				this.sendCmd("mail from: " + "<" + msg.getFromAddress() + ">");
				if (debug != null)  debug.println("mail from: " + "<" + msg.getFromAddress() + ">");
				this.sendCmd("rcpt to: " + "<" + msg.getToAddress() + ">");			// TODO: this should be generalized for multiple recipients
				if (debug != null)  debug.println("rcpt to: " + "<" + msg.getToAddress() + ">");
				this.sendCmd("data","354");
				if (debug != null)  debug.println("data");
				// begin the "letter"
				this.sendText(msg.toString());
				this.endBody();
				if (debug != null)  debug.println(msg.toString());
			}
		} catch (IOException e) {} //ignore for now
    }
    		
    /*
     *  Simple sending procedure sends an OutgoingMessage.
     *  Since this is not what is read in with readMessage, a JPMailMessage needs to be converted into one of these
     *  to be sent out.  It is presumed that the body is encrypted with the public key corresponding to the rcptLbl.
     * @param index
     * @return
     * @throws IOException
     */
/*    public void sendMessage(OutgoingMessage msg)
    {
		BufferedReader in = this.in; // use locals so NPE-analysis works
	
			if (!isConnected) {
		    return null;//throw new IOException("not connected.");
		}
		
		try {
			if (msg != null) {
				// generate the "envelope"
				this.sendCmd("mail from: " + "<" + msg.getFromAddress() + ">");
				this.sendCmd("rcpt to: " + "<" + msg.getToAddress() + ">");			// TODO: this should be generalized for multiple recipients
				this.sendCmd("data","354");
				// begin the "letter"
				this.sendField("From", msg.getFromAddress());
				this.sendField("To", msg.getToAddress());
				//this.sendField("Date",msg.getSendDate());
				this.sendField("X-Jif-Label", msg.getLabel());
				this.sendField("Subject", msg.getSubject());
				this.beginBody();
				this.sendText(msg.getBody());
				this.endBody();
			}
			else  if (debug != null) debug.println("Message was null");
		}
		catch (IOException e) {} //ignore for now
    }
*/  
    /* sends a message according to the label assigned to it.
     *  the owner should be the caller so that he can declassify the message and send it out with a different
     *  label.  For the moment, the outgoing socket is owned by the Owner.  In the future, we will want to make
     *  it public or something else ({siis:} for example) and then insert new and interesting policies here.
     * @param index
     * @return
     * @throws IOException
     */
/*    public void sendMessage(OutMessage msg) where caller(Owner)
    {
		BufferedReader in = this.in; // use locals so NPE-analysis works
	
			if (!isConnected) {
		    return null;//throw new IOException("not connected.");
		}
		
		try {
			if (msg != null) {
				// generate the "envelope"
				this.sendCmd("mail from: " + "<" + msg.getFromAddress() + ">");
				this.sendCmd("rcpt to: " + "<" + msg.getToAddress() + ">");			// TODO: this should be generalized for multiple recipients
				this.sendCmd("data","354");
				// begin the "letter"
				this.sendField("From", msg.getFromAddress());
				this.sendField("To", msg.getToAddress());
				//this.sendField("Date",msg.getSendDate());
				//this.sendField("X-Jif-Label", msg.getLabel()); // change this somehow -- need to get the label from the Message itself.
				this.sendField("Subject", msg.getSubject());
				this.beginBody();
				this.sendText(msg.getBody());
				this.endBody();
			}
			else if (debugP actsFor Owner) if (debug != null) debug.println("Message was null");
		}
		catch (IOException e) {} //ignore for now
    }
*/  
	/**
	 * @param args
	 */

     /* TODO Notes: could create a version without prompts
     *        not sure whether the input stream should be labeled as 
     *        not sure how outS should be parameterized -- the problem is that we don't get sub-typing
     *        when there is a graphic user interface, this can be an interface to it
     */
     
    /**
     * prompts to PrintStream and reads from BufferedReader
     * @param inS input stream to read data in for EMail fields
     * @param outS output stream for prompting which field to read next
     * @param user 
     * @param lbl the label applied to input and to the return value, likely 
     * @return the message constructed from the inputs
     */

    // we could make this public, instead of parameterizing by lbl
    // since it will need to be labeled with  soon.
    // FIXME:for now we use a hack--pass on the user's authority so I can look up the rcptLbl for the body parameter.
    // 		 perhaps another option would be to check if it is already labeled more highly than Mgr and in that case
    //		 delay the labeling of the body until later. 
    public JPMailMessage readMessage(BufferedReader inS, PrintStream outS, Principal user) 
    {
		String toAddress = null;
		String subject = null;
		String date = null;
		String rcptLblStr = null;
		Principal rcptPtmp = null;
//		label{} rcptLbltmp = new label{}; // meaningless assignment -- just to give it a value
		
		final StringBuffer buf = new StringBuffer();
		
		if (outS != null && inS != null) {
			try {
				outS.print("To: ");		// TODO:expand to an Array
				toAddress = inS.readLine();
				
				outS.print("Subject: ");
				subject = inS.readLine();
				// TODO: add date in
				outS.print("Label: ");
				rcptLblStr = inS.readLine();
				outS.println("Enter the body, ending with <CR><LF>.<CR><LF>:");
				String line = "";
				try {
					do {
						buf.append(line + "\n");
						line = inS.readLine();
					} while (line != null && line.compareTo(".") != 0);
				}
				catch (IOException e) {}  // not sure what would cause this
				catch (NullPointerException e) {} // due to buf.append and line.compareTo
			}
			catch (IOException e) {} // shouldn't happen
		}
		// look up rcptLbl
		if (debug != null) {
			debug.println("About to look up the label ");
			debug.println("{" + rcptLblStr + ":}");
		}
		
// PROBLEM: I thought that lbl was {}, but it's actually , so it's not less than {Mgr:} so we're not looking this up correctly
//          We actually need a declassification, just to look up the label principal.
//			This may not be optimal.
//			How to get around this?  leave it as the higher secrecy for now and when we declassify, we'll apply the right
//			secrecy to the body
		//if (lbl <= {Mgr:}) {  // manager needs to dominate to access policy
		if (true) {
			DeclassStringClosure dsClo = new DeclassStringClosure(rcptLblStr);
			String rcptLblStr1 = null;
			try {
				rcptLblStr1 = (String)PrincipalUtil.authorize(user, null,dsClo).invoke();
			} catch (ClassCastException impossible) {
			} catch (NullPointerException authFailed) {}
			
			if (debug != null)  debug.println("Looking up the label...");
			final Principal rcpt = policy == null ? null : policy.getPrincipalSec(rcptLblStr1);
			try {
				if (debug!=null) debug.println(((Principal)rcpt).getName());
			} catch (NullPointerException ignore) {}
			rcptPtmp = rcpt;
			
		//else {
		//	rcptPtmp = user;
		//	rcptLbltmp = lbl;
		//}

		final Principal rcptP = rcptPtmp;
//		final label{} rcptLbl = rcptLbltmp;
		String bodyText1 = buf == null ? null : buf.toString();

		DeclassMsgBodyClosure edmbClo = new DeclassMsgBodyClosure(bodyText1);
		String bodyText = null;
		try {
			bodyText = (String)PrincipalUtil.authorize(user, null,edmbClo).invoke();
		} catch (NullPointerException authFailed) {
		} catch (ClassCastException impossible) {}

		final JPMailMessage msg = new JPMailMessage(toAddress, // to
												this.emailAddress, // from)
	 											date, // date
	 											subject, // subject
	 											rcptLblStr,  // label string
	 											rcptP,
	 											null,
	 											bodyText);  // body text labeled with rcptLbl
		 if (debug != null) {
			final Principal p = null;
			if (p == null) debug.println("PROBLEMS! label on bodyText is null");
			else {
				debug.println("The label on bodyText is: " + p.getName());
				debug.println("rcptLbl <= {" + p.getName() + ":}");
			}

			if (msg != null) debug.println("Read in the message: " + msg.getFromAddress());
			else debug.println("Couldn't make the message for some reason");
		}
		
	 	return msg;
	 	}
		return null;
	 }	

    // presumes that the message has been declassified, but the bodyText will remain at 
    // which is presumably declassifiable by 
    // then we can look up the correct label in mph
    // and reclassify the body with that label
/*    public JPMailMessage{} reclassifyMessage{Mgr:}(JPMailMessage{} msg, principal{} user) 
    {
    		if (msg == null) return null;
    		
    		if (debug != null) if (debugP actsFor Mgr) debug.println("Looking up the label...");
		final principal{} rcpt = mph == null ? null : mph.getPrincipal(msg.getRcptLblStr());
		try {
			if (debug!=null) if (debugP actsFor Mgr) debug.println("The mph returned: " + ((Principal)rcpt).name());
		} catch (NullPointerException ignore) {}
		final label{} rcptLbl = {rcpt:};  //FIXME: presumes that the lblStr is just a principal and makes it a simple label
			
		JPMailMessage{} newMsg = null;
		final label{} originalRcptLbl = msg.getRcptLbl();
    		if (originalRcptLbl <= ) {
			String bodyText = msg.getBody();
			newMsg = new JPMailMessage(msg.getToAddress(), // to
									 msg.getFromAddress(), // from)
	 								 msg.getSendDate(), // date
	 								 msg.getSubject(), // subject
	 								 msg.getRcptLblStr(),  // label string
	 								 rcpt,
	 								 rcptLbl,  // actual corresponding label
	 								 declassify(bodyText,));  // body text labeled with rcptLbl)
		}
    		return newMsg;
    	}
*/
    public static void main(String[] args) {
		String mainPstr = null;
		try {
			mainPstr = args != null ? args[0] : "NEED TO ENTER USER PRINCIPAL NAME";
		} catch (ArrayIndexOutOfBoundsException e) {mainPstr = "NEED TO ENTER USER PRINCIPAL NAME"; return;}
		
		PolicyStore policy = null;
		try {
			policy = JifPolicy.setupPolicy(mainPstr);
		} catch (SecurityException e) {}
		
		Principal mainP = (policy != null) ? policy.getPrincipal(mainPstr) : null;
		final Principal me = mainP;
		
		jif.runtime.Runtime runtime = null;
		try {
			runtime = (mainP == null ? null : jif.runtime.Runtime.getRuntime());
		} catch (SecurityException e) {}

		// from here on, user and the principal entered in the command-line should be able to be used interchangeably
		BufferedReader inS = null; 
		PrintStream outS = null;
	 	try{
	 	    outS = runtime.stdout();
	 	}
	 	catch (SecurityException ex) {/* should do something here*/}
		catch (NullPointerException e) {}

		PrintStream debug = null;
	 	try{
	 	    debug = runtime.stdout();
	 	}
	 	catch (SecurityException ex) {/* should do something here*/}
		catch (NullPointerException e) {}

 		try {
 			inS = new BufferedReader(new InputStreamReader(runtime.stdin()));
 		}
 		catch (SecurityException ex) {if (outS != null) outS.println("Security exception thrown when opening input stream!");}
 		catch (NullPointerException e) {}
	
		final char[] pw2 = util.Password.getPassword("password-smtp", me);
		final byte[] pwBytes = (pw2 == null ? null : new byte[pw2.length]);
		try {
			for (int i = 0; i < pwBytes.length; i++)
				pwBytes[i] = (byte)pw2[i];
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (NullPointerException e) {}
		
		String smtpServer = null;
		String username = null;
		String emailAddress = null;
		try {
			if (args != null) {
				smtpServer = args[1];
				username = args[2];
				emailAddress = args[3];
			}
		} catch (ArrayIndexOutOfBoundsException e) {}
		
		if (true)
		{
			final MailSenderCrypto smtp = 
			    new MailSenderCrypto(smtpServer,username,emailAddress, 
						     pwBytes, 25, false, policy, me, null);
					    
			if (outS != null) outS.println("Getting connection...");

		 	try {
		 	    smtp.connect();  // needs smtp's authority
		 	}
		 	catch (IOException e) {}// if (outS != null) outS.println("Failed to connect.");}
		
		 	if (outS != null) outS.println("connected!");
	
		 	// read in message at my own security level
	 		final JPMailMessage msg = smtp.readMessage(inS,outS,me);

	 		// declassifies all header info, but body remains at level of recipient
			JPMailMessage newMsg = null;
			EmailHdrDeclassClosure ehdClo = new EmailHdrDeclassClosure(msg);
			try {
				newMsg = (JPMailMessage)PrincipalUtil.authorize(me,null,ehdClo).invoke();
			} catch(ClassCastException impossible) {
			} catch(NullPointerException notAuthorized) {return;}
			final JPMailMessage pubMsg = newMsg;
			if (outS != null) outS.println("successfully declassified JPMailMessage headers");
	
 			final MimeMailMessage mmm = pubMsg == null ? null : pubMsg.toMimeMailMessage(debug, me);
		 	if (outS != null && mmm != null) outS.println(mmm.getFromAddress()); 
		 	if (outS != null && mmm != null) outS.println(mmm.toString()); 

 			smtp.sendMessage(mmm);

			try {
				smtp.close();		// need to close so that someone else can open
			}
			catch (IOException e) {} // ignore
		}
    }
}
