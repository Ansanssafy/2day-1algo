import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250302_1976 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        int chk;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                chk = Integer.parseInt(st.nextToken());
                if(chk == 1){
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        boolean isPossible = true;
        for(int i = 1; i < M; i++){
            if(start != find(Integer.parseInt(st.nextToken()))){
                isPossible = false;
                break;
            }
        }
        if(isPossible){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    static int find(int v){
        if(parents[v] != v) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
    static void union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);

        if(rootI != rootJ){
            if(rootI < rootJ){
                parents[rootJ] = rootI;
            }else{
                parents[rootI] = rootJ;
            }
        }
    }
}
