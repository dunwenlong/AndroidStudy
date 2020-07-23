package niuke;

/**
 * @author Dun Wenlong
 * @time 2020/7/5 11:27
 */
import java.util.Scanner;

public class MarkNumber{
    public static String MarkNum(String str){
        char[] cs = str.toCharArray();
        StringBuilder stb = new StringBuilder();
        StringBuilder tempStb = new StringBuilder();
        for(int i=0; i<cs.length; i++){
            if(cs[i]>=0&&cs[i]<='9'){
                tempStb.append(cs[i]);
            } else{
                if(tempStb==null||tempStb.length()<1){
                    stb.append(cs[i]);
                } else{
                    stb.append("*");
                    stb.append(tempStb);
                    stb.append("*");
                    tempStb.replace(0, tempStb.length(),"");
                    stb.append(cs[i]);
                }
            }
        }
        if(tempStb!=null && tempStb.length()>0){
            stb.append("*");
            stb.append(tempStb);
            stb.append("*");
        }
        return stb.toString();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(MarkNumber.MarkNum(str));
        }
    }
}