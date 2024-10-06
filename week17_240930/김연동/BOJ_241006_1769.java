import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241006_1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int count = 0;

        while (line.length() > 1) {
            int sum = 0;
            for (char c : line.toCharArray()) {
                sum += c - '0';
            }
            line = String.valueOf(sum);
            count++;
        }

        System.out.println(count);
        if (Integer.parseInt(line) % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
