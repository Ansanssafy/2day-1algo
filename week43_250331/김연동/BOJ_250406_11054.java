import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250406_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());

        int[] arr = new int[A + 1];
        int[] dp = new int[A + 1];
        int[] dp2 = new int[A + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        int temp2 = 0;
        for(int i = 1; i <= A; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                temp = Math.max(temp, dp[i]);
            }
        }
        for(int i = A; i >= 1; i--) {
            dp2[i] = 1;
            for(int j = A; j > i; j--) {
                if(arr[j] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
                temp2 = Math.max(temp2, dp2[i]);
            }
        }
        int result = 0;
        for(int i = 1; i <= A; i++) {
            result = Math.max(result, dp[i] + dp2[i] - 1);  
        }
        System.out.println(result);
    }
}
