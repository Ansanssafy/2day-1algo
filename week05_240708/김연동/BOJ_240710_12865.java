import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240710_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        int[][] dp = new int[N + 1][K + 1];

        for (int n = 1; n <= N; n++) {
        st = new StringTokenizer(br.readLine());

        weights[n] = Integer.parseInt(st.nextToken());
        values[n] = Integer.parseInt(st.nextToken());

        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
