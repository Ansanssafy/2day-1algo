import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250209_15651 {
    static StringBuilder sb;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0, "");
        System.out.println(sb.toString());
    }
    static void dfs(int len, String result) {
        if (len == M) {
            sb.append(result.strip()).append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            dfs(len + 1, result + i + " ");
        }
    }
}
