import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_241117_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            switch (line) {
                case "push_front":
                    int temp = Integer.parseInt(st.nextToken());
                    q.offerFirst(temp);
                    break;
                case "push_back":
                    int temp2 = Integer.parseInt(st.nextToken());
                    q.offerLast(temp2);
                    break;
                case "pop_front":
                    sb.append(q.isEmpty() ? -1 : q.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(q.isEmpty() ? -1 : q.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
