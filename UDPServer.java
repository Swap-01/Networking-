import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.*;
import java.util.*;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        byte[] senddata = new byte[1024];
        byte[] recievedata = new byte[1024];
        System.out.println("Waiting for connection: ");
        while (true) {
            DatagramSocket ds = new DatagramSocket(9999);
            DatagramPacket dp = new DatagramPacket(recievedata, recievedata.length);
            ds.receive(dp);
            String message = new String(dp.getData());
            InetAddress ipAddress = dp.getAddress();
            int port = dp.getPort();
            String capitalSentence = message.toUpperCase() + '\n';
            senddata = capitalSentence.getBytes();
            DatagramPacket dp1 = new DatagramPacket(senddata, senddata.length, ipAddress, port);
            ds.send(dp1);
            System.out.println("Message Recieved:   " + message);
            ds.close();

        }

    }

}
