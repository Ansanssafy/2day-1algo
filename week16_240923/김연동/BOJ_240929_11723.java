import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_240929_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();

        int T = Integer.parseInt(br.readLine());

        String line;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line = st.nextToken();

            if (line.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);

            } else if (line.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);

            } else if (line.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(set.contains(x) ? "1\n" : "0\n");

            } else if (line.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x)) {
                    set.remove(x);
                } else {
                    set.add(x);
                }

            } else if (line.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j); // 1부터 20까지 모두 추가

                }

            } else if (line.equals("empty")) {
                set.clear();
            }
        }

        System.out.println(sb.toString());
    }
}
