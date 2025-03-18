    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class BOJ_250315_20040 {
        static int[] parents;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parents = new int[n];
            for(int i = 0; i < n; i++){
                parents[i] = i;
            }

            int start;
            int end;
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                if(find(start) == find(end)){
                    System.out.println(i + 1);
                    return;
                }
                union(start, end);
            }
            System.out.println(0);
        }
        static  int find(int x) {
            if(parents[x] != x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
        static void union(int start, int end) {
            int rootI = find(start);
            int rootJ = find(end);

            if (rootI != rootJ) {
                parents[rootJ] = rootI;
            }
        }
    }
