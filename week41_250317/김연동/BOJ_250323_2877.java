import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250323_2877 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int len = 1;
        int count = 2;

        while(K > count){
            len++;
            K -= count;
            count *= 2;
        }
        K--;
        for(int i = len - 1; i >= 0; i--){
            if((K & (1 << i)) == 0){
                sb.append(4);
            }else{
                sb.append(7);
            }
        }
        System.out.println(sb.toString());
    }
}
