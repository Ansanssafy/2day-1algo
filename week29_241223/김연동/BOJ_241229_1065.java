import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241229_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 99;

        if (N < 100) {
            System.out.println(N);
        } else {
            int hundred;
            int ten;
            int one;

            for (int i = 100; i <= N; i++) {
                hundred = i / 100;
                ten = (i / 10) % 10;
                one = i % 10;

                if ((hundred - ten) == (ten - one)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}