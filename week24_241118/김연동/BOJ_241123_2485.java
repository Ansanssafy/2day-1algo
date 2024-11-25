import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241123_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long tmp = arr[1] - arr[0];
        for(int i = 1; i < N - 1; i++){
            tmp = gcd(tmp,arr[i + 1] - arr[i]);
        }
        System.out.println(((arr[N - 1] - arr[0]) / tmp + 1) - arr.length);

    }

    public static long gcd(long a, long b) {
        if (b != 0){
            return gcd(b, a % b);
        }else{
            return a;
        }
    }
}
