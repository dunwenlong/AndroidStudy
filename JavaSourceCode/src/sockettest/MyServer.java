package sockettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Dun Wenlong
 * @time 2020/6/23 16:49
 */
public class MyServer {
    public static void main(String[] args){
        //port
        int port = 1108;
        // Save the information from Client
        String info = null;
        // Create ServerSocket and Monitor the port
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            // Use accept() to Monitor the relation from client
            Socket socket = serverSocket.accept();
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(is);
            while((info=br.readLine())!= null){
                System.out.println("收到来信，内容是："+info);
            }
            socket.shutdownInput();
            // Answer the client
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            os.write("我同意");
            os.flush();
            socket.shutdownOutput();
            is.close();
            os.close();
            br.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
