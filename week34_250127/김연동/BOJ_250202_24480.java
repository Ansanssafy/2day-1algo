import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_250202_24480 {
    static ArrayList<Integer>[] arr;
    static int[] visited;
    static StringBuilder sb;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        arr = new ArrayList[N + 1];

        for(int i = 0; i < N + 1; i++) {
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
            Collections.sort(arr[i], Collections.reverseOrder());
        }
        idx = 1;
        dfs(R);
        for(int i = 1; i < N + 1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int R) {
        visited[R] = idx;
        for(int i : arr[R]) {
            if(visited[i] == 0) {
                idx++;
                dfs(i);
            }
        }
    }
}
