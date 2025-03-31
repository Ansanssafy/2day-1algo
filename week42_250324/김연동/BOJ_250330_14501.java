import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250330_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] tArr = new int[N];
        int[] pArr = new int[N];
        int[] dp = new int[N + 1];

        int T, P;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            tArr[i] = T;
            pArr[i] = P;
        }
        for(int i = 0; i < N; i++) {
            if(tArr[i] <= N - i){
                dp[i + tArr[i]] = Math.max(dp[i + tArr[i]], dp[i] + pArr[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
