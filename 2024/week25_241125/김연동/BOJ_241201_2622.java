import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241201_2622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int c;
        int result = 0;
        for(int a = 1; a <= N/3; a++){
            for(int b = a; b <= (N-a)/2; b++){
                c = N-a-b;
                if(b > c){
                    break;
                }
                if(c < a+b){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
