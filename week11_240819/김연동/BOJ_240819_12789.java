import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_240819_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            q1.offerLast(Integer.parseInt(st.nextToken()));
        }

        int num = 1;

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (!q2.isEmpty() && q2.peekLast() == num) {
                q2.pollLast();
                num++;
            } else if (!q1.isEmpty() && q1.peekFirst() == num) {
                q1.pollFirst();
                num++;
            } else if (!q1.isEmpty()) {
                q2.offerLast(q1.pollFirst());
            } else {
                break;
            }
        }

        if(q1.isEmpty() && q2.isEmpty()){
            System.out.println("Nice");
        }else {
            System.out.println("Sad");
        }
    }
}
