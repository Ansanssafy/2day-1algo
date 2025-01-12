import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_250112_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    pq.offer(num);
                    pq2.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    if (num == 1) {
                        delete(pq2, map);
                    } else {
                        delete(pq, map);
                    }
                }
            }
            while (!pq.isEmpty() && map.getOrDefault(pq.peek(), 0) == 0) {
                pq.poll();
            }
            while (!pq2.isEmpty() && map.getOrDefault(pq2.peek(), 0) == 0) {
                pq2.poll();
            }

            if (pq.isEmpty() || pq2.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(pq2.peek()).append(" ").append(pq.peek()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void delete(PriorityQueue<Integer> pq, HashMap<Integer, Integer> map) {
        while (!pq.isEmpty()) {
            int value = pq.poll();
            if (map.getOrDefault(value, 0) > 0) {
                map.put(value, map.get(value) - 1);
                if (map.get(value) == 0) {
                    map.remove(value);
                }
                break;
            }
        }
    }
}
