import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_240804_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        boolean check;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            Deque<Character> q = new ArrayDeque<>();
            check = true;

            for (char test : line.toCharArray()) {
                if (test == '(') {
                    q.offerLast(test);
                } else if (test == ')') {
                    if (q.isEmpty() || q.pollLast() != '(') {
                        check = false;
                        break;
                    }
                }
            }
            if (!q.isEmpty()) {
                check = false;
            }
            if (check) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
