import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_241013_1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int count = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            count++;

            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 2 * n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }
            int fail = set.iterator().next();
            sb.append(count).append(" ").append(arr[fail - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}