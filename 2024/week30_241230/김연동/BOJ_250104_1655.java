import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_250104_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 최소 힙 pq (중간 값 보다 큰 친구들)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 최대 힙 pq (중간 값 보다 작은 친구들) - 여기 루트 뽑아야함
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        int num;
        for(int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            // pq2에 먼저 삽입
            if (pq2.isEmpty() || num <= pq2.peek()) {
                pq2.offer(num);
            } else {
                pq.offer(num);
            }

            // 힙 크기 조정
            if (pq2.size() > pq.size() + 1) {
                pq.offer(pq2.poll());
            } else if (pq.size() > pq2.size()) {
                pq2.offer(pq.poll());
            }
            sb.append(pq2.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
