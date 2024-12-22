import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_241222_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offerLast(i);
        }

        while (q.size() > 1) {
            sb.append(q.pollFirst()).append(" ");
            q.offerLast(q.pollFirst());
        }
        sb.append(q.pollFirst());
        System.out.println(sb.toString());
    }
}
