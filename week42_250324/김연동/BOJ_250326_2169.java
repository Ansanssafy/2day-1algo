import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250326_2169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= M; i++) {
            dp[1][i] = dp[1][i - 1] + arr[1][i];
        }
        int[][] left = new int[N + 1][M + 1];
        int[][] right = new int[N + 1][M + 1];
        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + arr[i][j];
            }

            left[i][1] = dp[i][1];
            for(int j = 2; j <= M; j++) {
                left[i][j] = Math.max(left[i][j - 1] + arr[i][j], dp[i][j]);
            }

            right[i][M] = dp[i][M];
            for(int j = M - 1; j >=1; j--){
                right[i][j] = Math.max(right[i][j + 1] + arr[i][j], dp[i][j]);
            }

            for(int j = 1; j <= M; j++){
                dp[i][j] = Math.max(left[i][j], right[i][j]);
            }
        }

        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[N][M]);
    }
}
