import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240617_10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N + 1][10];

		for (int j = 1; j < 10; j++) {
			dp[1][j] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j > 0) {
					dp[i][j] += dp[i - 1][j - 1];
				}
				if (j < 9) {
					dp[i][j] += dp[i - 1][j + 1];
				}
				dp[i][j] %= 1000000000;
			}
		}

		long result = 0;

		for (int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		result %= 1000000000;
		System.out.println(result);
	}
}
