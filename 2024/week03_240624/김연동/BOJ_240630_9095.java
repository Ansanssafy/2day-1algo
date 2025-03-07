import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240630_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int [11];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int tc = 0; tc < T; tc++){
            int n = Integer.parseInt(br.readLine());
            sb = sb.append(dp[n]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
