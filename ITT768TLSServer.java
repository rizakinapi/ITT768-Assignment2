/**
 * @author Name  :rizakinapi - 2014585361
 * ITT768 : NetProgramming
 */

import java.io.*;
import javax.net.ssl.*;
import java.security.*;
/**
* Java SSL Server Program using Application ID.
*/
public class JavaSslServer {
   
   public static void main(String args[]) {
       try {
           char[] password = "ITT768.P@ssw0rd".toCharArray();
           KeyStore ks = KeyStore.getInstance("JKS");
           FileInputStream fis = new FileInputStream("/home/keystore.file");
           ks.load(fis, password);
           
           KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

           kmf.init(ks, password);

           TrustManagerFactory tmf =  TrustManagerFactory.getInstance(TrustManagerFactor.getDefaultAlgorithm());
           tmf.init(ks);           

           SSLContext c =
                      SSLContext.getInstance("TLS");
           c.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        
           SSLServerSocketFactory sf = c.getServerSocketFactory();
       
           SSLServerSocket ss =
               (SSLServerSocket) sf.createServerSocket(8443);
          
           SSLSocket s = (SSLSocket) ss.accept();

           InputStream is = s.getInputStream();
           byte[] buffer = new byte[1024];
           int bytesRead = is.read(buffer);
           if (bytesRead == -1)
               throw new IOException("Error : Unexpected End-of-file Received");
           String received = new String(buffer, 0, bytesRead);

           System.out.println("Read " + received.length() + " bytes...");
           System.out.println(received);

           OutputStream os = s.getOutputStream();
           os.write(received.getBytes());

           System.out.println("Wrote " + received.length() + " bytes...");
           System.out.println(received);
       } catch (Exception e) {
           System.out.println("Error : Unexpected exception: " +
                              e.getMessage());
           e.printStackTrace();
       }
   }
   
}
