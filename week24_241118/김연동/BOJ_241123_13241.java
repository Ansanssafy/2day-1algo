import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241123_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        long mod = gcd(A, B);

        if(mod != 0) {
            System.out.println((A * B) / mod);
        }else{
            System.out.println(A * B);
        }
    }

    public static long gcd(long a, long b) {
        if (b != 0) {
            return gcd(b, a % b);
        } else {
            return a;
        }
    }
}
