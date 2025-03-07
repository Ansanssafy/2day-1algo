import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241013_5671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int i = start; i <= end; i++) {
                boolean[] room = new boolean[10];
                int num = i;
                boolean chk = true;

                while (num > 0) {
                    int temp = num % 10;
                    if (room[temp]) {
                        chk = false;
                        break;
                    }
                    room[temp] = true;
                    num /= 10;
                }

                if (chk) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}