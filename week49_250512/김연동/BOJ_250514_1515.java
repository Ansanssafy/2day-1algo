import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250514_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        String result = "";

        int N = 1;
        int index = 0;

        while (index < num.length()) {
            result = Integer.toString(N);
            for(int i = 0; i < result.length() && index < num.length(); i++) {
                if (result.charAt(i) == num.charAt(index)) {
                    index++;
                }
            }
            N++;
        }
        System.out.println(N - 1);
    }
}
