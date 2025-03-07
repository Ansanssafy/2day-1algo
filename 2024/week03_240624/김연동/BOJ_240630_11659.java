import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240630_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        int index = 1;
        while(st.hasMoreTokens()){
            arr[index] = Integer.parseInt(st.nextToken());
            dp[index] = dp[index - 1] + arr[index];
            index++;
        }

        for(int m = 0; m < M ; m++){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(dp[j] - dp[i-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
