import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250112_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int start = 1;
        int digit = 1;

        while (start <= N) {
            int end = Math.min(N, start * 10 - 1);
            result += (end - start + 1) * digit;
            start *= 10;
            digit++;
        }
        System.out.println(result);
    }
}
