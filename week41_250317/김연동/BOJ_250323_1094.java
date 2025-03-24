import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250323_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int count = 0;
        while(X > 0) {
            if((X & 1) == 1){
                count++;
            }
            X >>= 1;
        }
        System.out.println(count);
    }
}
