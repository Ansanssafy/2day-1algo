import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241212_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start, end,temp;
        int count = 1;
        for(int i = 1; i <= (N / 2) + 1; i++) {
           end = i + 1;
           temp = i + end;
           if(temp < N){
               while(true){
                   temp += ++end;
                   if(temp == N){
                       count++;
                       break;
                   }
                   if (temp > N) {
                       break;
                   }
               }
           }else if(temp == N) {
               count++;
           }
        }
        System.out.println(count);
    }
}
