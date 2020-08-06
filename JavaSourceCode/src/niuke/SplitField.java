package niuke;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/5 15:10
 */
public class SplitField {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] field = new int[m][n];
            for(int i=0; i<m; i++){
                char[] cs = sc.next().toCharArray();
                for(int j=0; j<n; j++){
                    field[i][j] =  cs[j] - '0';
                }
            }
            // sum[i][j]表示从左上角到field(i,j)的值得和
            int[][] sum = new int[m+1][n+1];
            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){
                    sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+field[i-1][j-1];
                }
            }
            int lef = 0;
            int rig = sum[m][n];
            int res = 0;
            while(lef <= rig){
                int mid = (rig-lef)/2 + lef;
                if(judge(mid, m, n, sum)){
                    lef = mid +1;
                    res = mid;
                } else {
                    rig = mid - 1;
                }
            }
            System.out.println(res);
        }
    }

    private static boolean judge(int mid, int m, int n, int[][] sum) {
        for(int i = 1; i<=n-3; i++){
            for(int j = i+1; j<= n-2; j++){
                for(int k = j+1; j<= n-1; j++){
                    int sRow = 0;
                    int count = 0;
                    for(int row = 1; row <= m; row ++){
                        int num1 = cal(sRow, 0, row, i, sum);
                        int num2 = cal(sRow, i, row, j, sum);
                        int num3 = cal(sRow, j, row, k, sum);
                        int num4 = cal(sRow, k, row, n, sum);
                        if(num1>=mid&&num2>=mid&&num3>=mid&&num4>=mid){
                            count++;
                            sRow = row;
                        }
                    }
                    if(count>=4){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int cal(int x, int y, int i, int j, int[][] sum) {
        return sum[x][y] - sum[x][j] - sum[i][y] + sum[i][j];
    }
}

//import java.util.Scanner;

/**
 * 网易——分田地,竖切枚举+二分查找,又是一个。。。题
 * created by liyurong
 **/
/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] fields = new int[n][m];
            for (int i = 0;i < n;i ++){
                char[] tmp = sc.next().toCharArray();
                for (int j = 0;j < m;j ++){
                    fields[i][j] = tmp[j] - '0';
                }
            }

            int[][] sum = new int[n + 1][m + 1];
            for (int i = 1;i <= n;i ++){
                for (int j = 1;j <= m;j ++){
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + fields[i - 1][j - 1];
                }
            }

            int left = 0;
            int right = sum[n][m];
            int res = 0;
            while (left <= right){
                int mid = (right - left) / 2 + left;
                if (judge(mid,n,m,sum)){
                    left = mid + 1;
                    res = mid;
                }else {
                    right = mid - 1;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
    public static boolean judge(int x,int n,int m,int[][] sum){
        for (int i = 1;i <= m - 3;i ++){
            for (int j = i + 1;j <= m - 2;j ++){
                for (int k = j + 1;k <= m - 1;k ++){
                    int lastRow = 0;
                    int count = 0;
                    for (int row = 1;row <= n;row ++){
                        int sum1 = cal(row,i,lastRow,0,sum);
                        int sum2 = cal(row,j,lastRow,i,sum);
                        int sum3 = cal(row,k,lastRow,j,sum);
                        int sum4 = cal(row,m,lastRow,k,sum);
                        if (sum1 >= x && sum2 >= x && sum3 >= x && sum4 >= x){
                            lastRow = row;
                            count ++;
                        }
                    }
                    if (count >= 4){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static int cal(int x,int y,int i,int j,int[][] sum){
        return sum[x][y] - sum[i][y] - sum[x][j] + sum[i][j];
    }
}*/
