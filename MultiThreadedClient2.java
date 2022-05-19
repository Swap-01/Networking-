import java.net.*;
import java.io.*;

public class MultiThreadedClient2 {
     public static void main(String[] args) throws Exception {
         try{
             Socket s = new Socket("127.0.0.1",8080);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream out = new DataOutputStream(s.getOutputStream());
             DataInputStream in  = new DataInputStream(s.getInputStream());
             String msg = " ";
             String servermsg = " ";
             while (! msg.equals("bye")){
                 System.out.println("Enter a number : ");
                 msg = br.readLine();
                 out.writeUTF(msg);
                 out.flush();
                 servermsg = in.readUTF();
                 System.out.println(servermsg);
             }
             s.close();
         }
         catch (Exception e){
            System.out.println(e);
         }
     }
}


