import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_250113_11724 {
    static int N, M, V;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int result = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }
    private static void dfs(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : graph[v]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
