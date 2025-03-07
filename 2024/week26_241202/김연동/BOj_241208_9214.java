import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOj_241208_9214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2;

        int count = 1;

        while (true) {
            String line = br.readLine();

            if (line.equals("0")){
                break;
            }

            while (true) {
                sb2 = new StringBuilder();

                if (line.length() % 2 == 1) break;

                for (int i = 0; i < line.length(); i += 2) {
                    int idx = Integer.parseInt(String.valueOf(line.charAt(i)));

                    for (int j = 0; j < idx; j++) {
                        sb2.append(line.charAt(i + 1));
                    }
                }

                if (line.equals(sb2.toString())) {
                    break;
                }
                line = sb2.toString();
            }
            sb.append("Test ").append(count++).append(": ").append(line).append("\n");
        }
        System.out.print(sb.toString());
    }
}
