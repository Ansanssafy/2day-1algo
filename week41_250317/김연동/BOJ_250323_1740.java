import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250323_1740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long powNum = 1;
        long result = 0;
        while(N > 0){
            if((N & 1) == 1){
                result += powNum;
            }
            powNum *= 3;
            N >>= 1;
        }
        System.out.println(result);
    }
}