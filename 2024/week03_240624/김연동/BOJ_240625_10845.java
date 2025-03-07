import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_240625_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    q.offerLast(value);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.pollFirst()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
