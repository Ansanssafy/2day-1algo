import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_250113_13023 {
    static int N, M, a, b, depth;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];

        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            if(dfs(i,0,visited)){
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
    private static boolean dfs(int node,int depth, boolean[] visited) {
        if(depth == 4) {
            return true;
        }

        visited[node] = true;

        for(int nei : graph[node]) {
            if (!visited[nei]) {
                if(dfs(nei, depth + 1, visited)){
                    return true;
                }
            }
        }
        visited[node] = false;
        return false;
    }
}
