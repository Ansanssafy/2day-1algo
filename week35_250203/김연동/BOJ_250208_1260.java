import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_250208_1260 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(arr[i]);
        }
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb.toString());
    }
    static void dfs(int r) {
        visited[r] = true;
        sb.append(r).append(" ");
        for (int v : arr[r]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    static void bfs(int r) {
        Deque<Integer> q = new ArrayDeque<>();
        visited = new boolean[N + 1];
        q.offerLast(r);
        visited[r] = true;
        while (!q.isEmpty()) {
            int now = q.pollFirst();
            sb.append(now).append(" ");
            for (int v : arr[now]) {
                if (!visited[v]) {
                    q.offerLast(v);
                    visited[v] = true;
                }
            }
        }
    }
}
