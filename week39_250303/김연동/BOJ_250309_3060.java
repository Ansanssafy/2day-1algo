import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250309_3060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int N, sum, day;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            day = 1;
            sum = 0;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 6; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            while(sum <= N) {
                sum *= 4;
                day++;
            }
            sb.append(day).append("\n");
        }
        System.out.println(sb.toString());
    }
}