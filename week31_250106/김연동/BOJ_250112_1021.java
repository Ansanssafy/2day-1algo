import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_250112_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        int[] arr = new int[M];

        for (int i = 1; i <= N; i++) {
            q.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int target : arr) {
            int index = 0;
            for (int num : q) {
                if (num == target){
                    break;
                }
                index++;
            }
            if (index <= q.size() / 2) {
                for (int i = 0; i < index; i++) {
                    q.offerLast(q.pollFirst());
                    result++;
                }
            } else {
                for (int i = 0; i < q.size() - index; i++) {
                    q.offerFirst(q.pollLast());
                    result++;
                }
            }
            q.pollFirst();
        }
        System.out.println(result);
    }
}
