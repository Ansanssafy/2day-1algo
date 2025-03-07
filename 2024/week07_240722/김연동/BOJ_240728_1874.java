import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_240728_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int test = 1;
        boolean possible = true;

        for (int num : arr) {
            while (test <= num) {
                q.offerLast(test++);
                sb.append("+\n");
            }
            if (q.peekLast() == num) {
                q.pollLast();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}