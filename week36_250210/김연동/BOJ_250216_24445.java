import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_250216_24445 {
    static int N, M, R;
    static ArrayList<Integer>[] arr;
    static int[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        int u, v;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        for(int i = 0; i < N + 1; i++) {
            Collections.sort(arr[i],Collections.reverseOrder());
        }
        bfs(R);
        for(int i = 1; i < N + 1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int r) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(r);
        visited[r] = 1;

        int result = 2;
        while(!q.isEmpty()) {
            int now = q.pollFirst();
            for(int i : arr[now]) {
                if(visited[i] == 0) {
                    visited[i] = result++;
                    q.offerLast(i);
                }
            }
        }
    }
}
