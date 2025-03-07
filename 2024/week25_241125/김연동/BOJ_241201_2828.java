import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241201_2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int start = 1;
        int end = K;
        int result = 0;

        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (apple < start) {
                result += start - apple;
                end -= start - apple;
                start = apple;
            } else if (apple > end) {
                result += apple - end;
                start += apple - end;
                end = apple;

                if (end > M) {
                    end = M;
                    start = M - K + 1;
                }
            }
        }

        System.out.println(result);
    }
}