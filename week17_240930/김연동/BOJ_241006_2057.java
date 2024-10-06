import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BOJ_241006_2057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long[] arr = new long[21];
        if (N == 0) {
            System.out.println("NO");
            return;
        }

        arr[0] = 1L;
        for (int i = 1; i <= 20; i++) {
            arr[i] = arr[i-1] * i;
        }

        for (int i = 20; i >= 0; i--) {
            if (N >= arr[i]) {
                N -= arr[i];
            }
        }

        if (N == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
