import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_250512_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        Deque<Character> q = new ArrayDeque<>();
        Deque<Character> q2 = new ArrayDeque<>();

        for(int i = 0; i < line.length(); i++) {
            q.offerLast(line.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            if(command == 'L'){
                if (!q.isEmpty()) {
                    q2.offerFirst(q.pollLast());
                }
            }else if(command == 'D'){
                if (!q2.isEmpty()) {
                    q.offerLast(q2.pollFirst());
                }
            }else if(command == 'B'){
                if (!q.isEmpty()){
                    q.pollLast();
                }
            }else{
                char x = st.nextToken().charAt(0);
                q.offerLast(x);
            }
        }

        for (char c : q) {
            sb.append(c);
        }
        for (char c : q2) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
