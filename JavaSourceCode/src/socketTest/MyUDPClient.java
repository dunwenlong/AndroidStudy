package socketTest;

import java.io.IOException;
import java.net.*;

/**
 * @author Dun Wenlong
 * @time 2020/6/23 19:25
 */
public class MyUDPClient {
    public static void main(String[] args){
        try {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 1081;
            byte[] data = "你好！".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);

            byte[] data2 = new byte[1024];
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
            socket.receive(packet2);
            String info = new String(data2, 0, packet2.getLength());
            System.out.println("服务器端回复："+info);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
