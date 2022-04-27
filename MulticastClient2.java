import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient2 {
    public static void main(String args[]) throws IOException {
        InetAddress add = InetAddress.getByName("224.0.0.3");
        byte[] recievedata = new byte[1024];
        MulticastSocket ms = new MulticastSocket(8080);
        ms.joinGroup(add);
        while (true) {
            DatagramPacket dp = new DatagramPacket(recievedata, recievedata.length);
            ms.receive(dp);
            String message = new String(dp.getData());
            System.out.println(" Client2 message Recieved from server:   " + message);

        }

    }

}