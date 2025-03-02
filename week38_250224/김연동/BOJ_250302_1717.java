import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250302_1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int  i = 0; i <= n; i++){
            parent[i] = i;
        }

        int command;
        int a, b;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(command == 0){
                union(a, b);
            }else{
                if(find(a) == find(b)){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
    static int find(int v){
        if(parent[v] != v){
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parent[rootA] = rootB;
        }
    }
}
