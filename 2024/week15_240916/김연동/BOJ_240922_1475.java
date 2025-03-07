import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240922_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] count = new int[10];
        for(int i = 0; i < line.length(); i++) {
            count[line.charAt(i) - '0']++;
        }
        count[6] += count[9];
        count[9] = 0;
        if(count[6] % 2 == 0) {
            count[6] /= 2;
        }else{
            count[6] = (count[6] / 2) + 1;
        }
        int result = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > result) {
                result = count[i];
            }
        }
        System.out.println(result);
    }
}
