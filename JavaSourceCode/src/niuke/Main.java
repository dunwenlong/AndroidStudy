package niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public String mySort(int[] nums, int isUp){
        Arrays.sort(nums);
        StringBuilder stb = new StringBuilder();
        if(isUp == 0){
            for(int i=0; i<nums.length; i++){
                stb.append(nums[i]);
                stb.append(' ');
            }
        }
        if(isUp == 1){
            for(int i=nums.length-1; i>=0; i--){
                stb.append(nums[i]);
                stb.append(' ');
            }
        }
        return stb.toString().trim();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = null;
        Main main = new Main();
        while((temp = br.readLine())!= null){
            int n = Integer.parseInt(temp);
            String[] data = br.readLine().split(" ");
            int m = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            for(int i = 0; i<n; i++){
                nums[i] = Integer.parseInt(data[i]);
            }
            System.out.println(main.mySort(nums, m));
        }
    }
}