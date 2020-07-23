package sockettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Dun Wenlong
 * @time 2020/6/23 17:01
 */
public class MyClient {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1", 1108);
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            System.out.println("你好!");
            os.write("你好！");
            os.flush();
            socket.shutdownOutput();
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(is);
            String info = null;
            while((info=br.readLine())!=null){
                System.out.println("服务器："+info);
            }
            socket.shutdownInput();
            os.close();
            is.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
