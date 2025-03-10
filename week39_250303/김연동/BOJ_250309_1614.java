import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250309_1614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long count = Long.parseLong(br.readLine());

        long result = 0;
        if(1 <= count) {
            result += 5;
            if(N == 1 || N == 5){
                result += ((count - 1) * 4 * 2);
            }else if(N != 1 && N != 5){
                result += ((count - 1) * 4);
            }

            if(N == 1) {
                result += 3;
            }else if(N == 5) {
                result += 7;
            }else if(count % 2 == 0) {
                result += (N - 2);
            }else if(count % 2 != 0) {
                result += (4 - N);
            }
        }
        else {
            result+=(N - 1);
        }
        System.out.println(result);
    }
}
