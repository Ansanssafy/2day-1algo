import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241020_2097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 3) {
            System.out.println(4);
            return;
        }

        for (int i = 2; i < N; i++) {
            if (N <= i * i) {
                System.out.println((i - 1) * 4);
                break;
            } else if (N <= i * (i + 1)) {
                System.out.println((i - 1) * 4 + 2);
                break;
            }
        }
    }
}