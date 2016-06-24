/**
 * @author Name  :rizakinapi - 2014585361
 * ITT768 : NetProgramming
 */

import java.io.*;
import javax.net.ssl.*;
import java.security.*;
import com.ibm.i5os.jsse.SSLConfiguration;
/**
 * SSL Client Program.
 */
public class SslClient {
   
 
  public static void main(String args[]) {
 
      try {
           char[] password = "password".toCharArray();
           KeyStore ks = config.getKeyStore(password);
           KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

           kmf.init(ks, password);
          
           TrustManagerFactory tmf =  TrustManagerFactory.getInstance(TrustManagerFactor.getDefaultAlgorithm());
           tmf.init(ks);

           SSLContext c = SSLContext.getInstance("TLS");
           c.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
       
           SSLSocketFactory sf = c.getSocketFactory();
           
           SSLSocket s = (SSLSocket) sf.createSocket("localhost", 8433);
           
           iString sent = "Testing Java Client SSL write";
           OutputStream os = s.getOutputStream();
           os.write(sent.getBytes());
           
           System.out.println("Wrote " + sent.length() + " bytes...");
           System.out.println(sent);
           
           InputStream is = s.getInputStream();
           byte[] buffer = new byte[1024];
           int bytesRead = is.read(buffer);
           if (bytesRead == -1)
               throw new IOException("Unexpected End-of-file Received");
           String received = new String(buffer, 0, bytesRead);
           
           System.out.println("Read " + received.length() + " bytes...");
           System.out.println(received);
       } catch (Exception e) {
           System.out.println("Unexpected exception caught: " +
                              e.getMessage());
           e.printStackTrace();
       }
   }
   
}

