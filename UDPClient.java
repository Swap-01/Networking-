import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        byte[] senddata = new byte[1024];
        byte[] recievedata = new byte[1024];
        System.out.println("Enter the message:  ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InetAddress IpAddress = InetAddress.getByName("LocalHost");
        DatagramSocket ds = new DatagramSocket();
        String sentence = br.readLine();
        senddata = sentence.getBytes();
        DatagramPacket dp = new DatagramPacket(senddata, senddata.length, IpAddress, 9999);
        ds.send(dp);
        DatagramPacket dp1 = new DatagramPacket(recievedata, recievedata.length);
        ds.receive(dp1);
        String message = new String(dp1.getData());
        System.out.print("Recieved from the server:   " + message);
        ds.close();

    }
}
