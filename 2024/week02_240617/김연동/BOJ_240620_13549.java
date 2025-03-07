import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_240620_13549 {
    static int N;
    static int K;
    static boolean[] visited = new boolean[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println("0");
        } else {
            System.out.println(bfs(N));
        }
    }

    private static int bfs(int num) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(num, 0));
        visited[num] = true;

        while (!q.isEmpty()) {
            Node now = q.pollFirst();

            if (now.num == K) {
                return now.dist;
            }

            int[] next = {now.num * 2, now.num - 1, now.num + 1};

            for (int i = 0; i < 3; i++) {
                int nextNum = next[i];

                if (nextNum >= 0 && nextNum <= 200000 && !visited[nextNum]) {
                    visited[nextNum] = true;

                    if (i == 0) {
                        q.offerFirst(new Node(nextNum, now.dist)); // 순간이동은 우선적으로 처리
                    } else {
                        q.offerLast(new Node(nextNum, now.dist + 1)); // 걷기는 나중에 처리
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int num;
        int dist;

        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}
