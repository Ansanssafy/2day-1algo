import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_250202_24483 {
    static ArrayList<Long>[] arr;
    static long[] visited;
    static long[] visited2;
    static long idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());

        visited = new long[(int) (N + 1)];
        visited2 = new long[(int) (N + 1)];
        arr = new ArrayList[(int) (N + 1)];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        for (long i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long u = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            arr[(int) u].add(v);
            arr[(int) v].add(u);
        }
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(arr[i]);
        }
        idx = 1;
        dfs(R, 0);

        long result = 0;
        long temp;
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] != -1) {
                temp = visited[i] * visited2[i];
                result += temp;
            }
        }
        System.out.println(result);
    }
    static void dfs(long R, int depth) {
        visited[(int) R] = depth;
        visited2[(int) R] = idx++;
        for (long i : arr[(int) R]) {
            if (visited[(int) i] == -1) {
                dfs(i, depth + 1);
            }
        }
    }
}
