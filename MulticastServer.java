import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.*;
import java.util.*;

public class MulticastServer {
    public static void main(String[] args) throws IOException {
        InetAddress ipAddress = InetAddress.getByName("224.0.0.3");
        DatagramSocket ds = new DatagramSocket();
        System.out.println("Enter message");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        DatagramPacket dp = new DatagramPacket(message.getBytes(), message.getBytes().length, ipAddress, 8080);
        ds.send(dp);
        System.out.println("message sent successfully");

    }

}