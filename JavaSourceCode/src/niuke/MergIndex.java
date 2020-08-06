package niuke;

/**
 * @author Dun Wenlong
 * @time 2020/8/6 14:44
 */
import java.util.Scanner;
public class MergIndex{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            int k = 0;
            int j = 0;
            for(int i=0; i<n; i++){
                k = sc.nextInt();
                j = sc.nextInt();
                nums[k] += j;
            }
            for(int i=0; i<n; i++){
                if(nums[i]!=0){
                    System.out.println(i +" "+ nums[i]);
                } else{
                    continue;
                }
            }
        }
    }
}
