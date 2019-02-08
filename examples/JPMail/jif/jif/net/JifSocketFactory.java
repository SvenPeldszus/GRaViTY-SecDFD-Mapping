package jif.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

/**
 * A trivial client socket factory.
 */
public class JifSocketFactory extends SocketFactory
{
  private static int __JIF_SIG_OF_JAVA_CLASS$20030619 = 0;

  // Constructor.
  // ------------------------------------------------------------------

  public JifSocketFactory()
  {
    super();
  }

  // Instance methods.
  // ------------------------------------------------------------------

  public Socket createSocket() throws IOException
  {
    return new Socket();
  }

    public Socket createSocket(String host, int port) throws IOException, UnknownHostException
  {
    return new Socket(host, port);
  }

    public Socket createSocket(String host, int port, InetAddress localAddr, int localPort) throws IOException, UnknownHostException
  {
    return new Socket(host, port, localAddr, localPort);
  }

    public Socket createSocket(InetAddress address, int port) throws IOException
  {
    return new Socket(address, port);
  }

    public Socket createSocket(InetAddress address, int port, InetAddress localAddr, int localPort) throws IOException
  {
      return new Socket(address, port, localAddr, localPort);
  }
}