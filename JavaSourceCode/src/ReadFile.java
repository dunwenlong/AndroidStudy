/**
 * @author Dun Wenlong
 * @time 2020/6/19 16:24
 */

import java.io.*;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {

        // 创建所需读取文件的路径的输入窗口
        System.out.println("请输入你需要读取文件的路径：");
//        Scanner sc = new Scanner(System.in);
        File file = new File("F:\\github\\AndroidStudy\\JavaLockSourceCode\\src\\JsonInJava.java");
        read(file);
        // 自定义read方法，将给定路径的文件内容打印到控制台上
//        read(sc.nextLine());
//        sc.close();
    }


    private static void read(File file) {
        // 创建字符流对象，并根据已创建的字节流对象创建字符流对象
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader raf = null;

        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            raf = new BufferedReader(isr);

            String s = null;

            // 读取文件内容，并将其打印
            while((s = raf.readLine()) != null) {
                System.out.println(s);

            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                raf.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }

}
