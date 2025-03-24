import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250323_4673 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean[] chk = new boolean[10001];

        int temp;
        for(int i = 1; i < 10001; i++) {
            temp = d(i);

            if(temp < 10001){
                chk[temp] = true;
            }
        }
        for(int i = 1; i < 10001; i++) {
            if(!chk[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int d(int n){
        int sum = n;
        while (n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
