import java.io.*;
import java.net.*;

public class tcpClientside {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the Msg   \n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        Socket s = new Socket("LocalHost", 8000);
        DataOutputStream ds = new DataOutputStream(s.getOutputStream());
        ds.writeBytes(str1 + "\n");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str2 = br1.readLine();
        System.out.println("From Server  " + str2);
        s.close();
    }

}
