package niuke;

/**
 * @author Dun Wenlong
 * @time 2020/8/3 11:28
 */
public class TwoNumbersSum {
    public static int sum(int a, int b){
        int low = a^b;
        int carry = a&b;
        while(carry!=0){
            carry = carry<<1;
            a = low;
            b = carry;
            low = a^b;
            carry = a&b;
        }
        return low;
    }
    public static void main(String[] args){
        System.out.println(TwoNumbersSum.sum(21213,11312));
    }

}
