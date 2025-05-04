import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250504_13900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] dp = new long[N];
        long result = 0;

        long num;
        dp[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            dp[i] = num + dp[i - 1];
            result += dp[i - 1] * num;
        }
        System.out.println(result);
    }
}