import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.List;

/**
 * @author Dun Wenlong
 * @time 2020/6/21 15:52
 */
public class TestString {
    public static void main(String[] args){
//        String str1 = "abcd";
//        String str2 = new String("abcd");
//        String myStr = "aa" + "bb" + "cc" + "dd";
//        String h = "aabbccdd";
//        List<String> simpleList = List.of("Hello","world");
//        System.out.println(myStr == h);
//        System.out.println(str2 == str1);
        System.out.println("Hello,world!");
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        long [] id=threadMXBean.getAllThreadIds();
        for(long i:id){
            System.out.println(threadMXBean.getThreadInfo(i).getThreadName()+" "+threadMXBean.getThreadInfo(i).getThreadState());
        }
        System.out.println(threadMXBean.getThreadCount());
    }
}
