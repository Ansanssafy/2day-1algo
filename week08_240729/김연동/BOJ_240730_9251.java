import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240730_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String one = br.readLine();
        String two = br.readLine();

        char[] oArr = new char[one.length() + 1];
        char[] tArr = new char[two.length() + 1];

       for(int i = 0; i < one.length(); i++){
           oArr[i + 1] = one.charAt(i);
       }

       for(int i = 0; i < two.length(); i++){
           tArr[i + 1] = two.charAt(i);
       }

//        for(int i = 0; i < oArr.length; i++){
//            System.out.print(oArr[i]);
//        }
//        System.out.println();
//        for(int i = 0; i < tArr.length; i++){
//            System.out.print(tArr[i]);
//        }
//        System.out.println();

        int[][] dp = new int[one.length() + 1][two.length() + 1];

        for(int i = 1; i < one.length() + 1; i++){
            for(int j = 1; j < two.length() + 1; j++) {
                if(oArr[i] == tArr[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
//        // 출력 확인
//        for(int i = 0; i < dp.length; i++) {
//            {
//                for (int j = 0; j < dp[i].length; j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
        System.out.println(dp[one.length()][two.length()]);
    }
}
