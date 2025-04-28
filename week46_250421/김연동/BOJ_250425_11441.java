import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250425_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        int index = 1;
        while (st.hasMoreTokens()) {
            arr[index] = Integer.parseInt(st.nextToken());
            dp[index] = arr[index] + dp[index - 1];
            index++;
        }

        int M = Integer.parseInt(br.readLine());

        int i, j;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            sb.append(dp[j] - dp[i - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
