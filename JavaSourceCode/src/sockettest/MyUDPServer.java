package sockettest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Dun Wenlong
 * @time 2020/6/23 17:14
 */
public class MyUDPServer {
    public static void main(String[] args){
        try {
            //创建服务器端
            DatagramSocket socket = new DatagramSocket(1081);
            //创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            System.out.println("服务器端已成功启动，等待客户端发送数据");
            //接收客户端发送的数据
            socket.receive(packet);
            String info = new String(data, 0, packet.getLength());
            System.out.println("客户端消息："+info);
            //向客户端发送消息
            InetAddress address = packet.getAddress();
            System.out.println("客户端地址:"+address);
            int port = packet.getPort();
            byte[] data2 = "我不好！".getBytes();
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
            socket.send(packet2);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
