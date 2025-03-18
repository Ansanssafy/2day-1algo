import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_250315_15655 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int index = 0;
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0, "");
        System.out.println(sb.toString());
    }
    static void dfs(int start, int depth, String result) {
        if(depth == M) {
            sb.append(result).append("\n");
        }
        for(int i = start; i < N; i++) {
            dfs(i+1, depth+1, result + arr[i] + " ");
        }
    }
}
