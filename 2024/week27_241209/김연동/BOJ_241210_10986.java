import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241210_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long count = 0;
        st = new StringTokenizer(br.readLine());

        long[] dp = new long[N + 1];
        long[] cArr = new long[M];
        int index = 1;
        long temp;

        while(st.hasMoreTokens()) {
          temp = Long.parseLong(st.nextToken());
          dp[index] = (temp + dp[index - 1]) % M;
            if((dp[index] % M) == 0){
                count++;
            }

          if (dp[index] < 0) {
              dp[index] += M;
          }
          cArr[(int)dp[index]] += 1;
          index++;
        }

        for(int i = 0; i < cArr.length; i++) {
            count += (cArr[i] * (cArr[i] - 1)) / 2;
        }
        System.out.println(count);
    }
}
