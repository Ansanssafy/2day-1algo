import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_240616_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = Integer.MIN_VALUE;

		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int n = 1; n < N + 1; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}

		dp[1] = arr[1];
		
		if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }
		
		for (int i = 3; i < N + 1; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
		}
		System.out.println(dp[N]);

	}
}
