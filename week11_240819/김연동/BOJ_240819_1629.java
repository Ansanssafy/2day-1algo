import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240819_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }
    public static long pow(long A, long B, long C) {
        if(B == 1){
            return A % C;
        }
        long test = pow(A, B / 2, C);

        test = (test * test) % C;

        if (B % 2 == 1) {
            test = (test * A) % C;
        }

        return test;
    }
}