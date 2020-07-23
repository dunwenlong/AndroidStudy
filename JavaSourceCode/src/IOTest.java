import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/7/1 14:18
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = null;
//        while((str=br.readLine())!=null){
//            System.out.println(str);
//        }
//        br.close();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            System.out.println(in.nextInt());
        }
    }
}
