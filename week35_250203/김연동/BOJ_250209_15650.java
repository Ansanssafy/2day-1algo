import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250209_15650 {
    static StringBuilder sb;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(1, 0, "");
        System.out.println(sb.toString());
    }
    static void dfs(int start, int len, String result) {
        if (len == M) {
            sb.append(result.strip()).append('\n');
            return;
        }
        for (int i = start; i <= N; i++) {
            dfs(i + 1, len + 1, result + i + " ");
        }
    }
}
