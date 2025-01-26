import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250120_15649 {
    static boolean[] visited;
    static StringBuilder sb;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dfs(N, M, 0, "");
        System.out.println(sb.toString());
    }
    static void dfs(int n, int m, int len, String result) {
        if (len == M) {
            sb.append(result.strip()).append('\n');
            return;
        }
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(n, m, len+1, result + i + " ");
                visited[i] = false;
            }
        }
    }
}
