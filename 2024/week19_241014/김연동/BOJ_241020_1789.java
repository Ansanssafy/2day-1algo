import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241020_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long sum = 0;
        long count = 0;

        for (long i = 1; ; i++) {
            if (sum + i > N) {
                break;
            }
            sum += i;
            count++;
        }

        System.out.println(count);
    }
}