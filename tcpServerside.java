import java.io.*;
import java.net.*;

public class tcpServerside {
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting for connection\n ");
        ServerSocket ss = new ServerSocket(8000);

        while (true) {
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String Clientsent = br.readLine();
            System.out.println("Data has been sent " + Clientsent);
            String str3 = Clientsent.concat("Susmit Dutta");
            DataOutputStream ds = new DataOutputStream(s.getOutputStream());
            ds.writeBytes(str3 + "\n");
            s.close();

        }

    }

}
