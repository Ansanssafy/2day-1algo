import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_240630_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            switch (line){
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    q.offerLast(value);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.pollLast()).append("\n");
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
                case "top":
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
