import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250316_15652 {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(1, 0, "");
        System.out.println(sb.toString());
    }
    static void dfs(int start, int depth, String result) {
        if(depth == M) {
            sb.append(result).append("\n");
            return;
        }
        for(int i = start; i <= N; i++) {
           dfs(i, depth + 1, result + i + " ");
        }
    }
}
