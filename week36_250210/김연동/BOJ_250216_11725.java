import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_250216_11725 {
    static int N;
    static ArrayList<Integer>[] arr;
    static int[] Pnode;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N + 1];
        Pnode = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            arr[i] = new ArrayList<>();
        }
        int u,v;
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        dfs(1);
        for(int  i = 2; i < Pnode.length; i++) {
            sb.append(Pnode[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int now) {
        visited[now] = true;
        for(int i : arr[now]) {
           if(!visited[i]) {
               Pnode[i] = now;
               dfs(i);
           }
        }
    }
}
