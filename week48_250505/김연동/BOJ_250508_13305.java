import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250508_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N - 1];
        long[] cost = new long[N];
        int dSum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
            dSum += dist[i];

        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long result = cost[0] * dSum;
        long min = cost[0];

        for(int i = 0; i < N - 1; i++) {
            if(cost[i] < min) {
                result -= (min - cost[i]) * dSum;
                min = cost[i];
            }
            dSum -= dist[i];
        }
        System.out.println(result);
    }
}
