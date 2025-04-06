import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250406_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int A = Integer.parseInt(br.readLine());

        int[] arr = new int[A + 1];
        int[] dp = new int[A + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int i = 1; i <= A; i++) {
            dp[i] = arr[i];
            for(int j = 1; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
