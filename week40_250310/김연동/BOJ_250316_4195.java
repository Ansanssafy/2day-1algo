import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_250316_4195 {
    static HashMap<String, Integer> map;
    static int[] parent;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int F;
        String friend1, friend2;
        for(int tc = 0; tc < T; tc++) {
            F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            parent = new int[F * 2]; // 연결용
            size = new int[F * 2]; // 사이즈 출력용
            int friendNum = 0;

            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for(int f = 0; f < F; f++) {
                st = new StringTokenizer(br.readLine());
                friend1 = st.nextToken();
                friend2 = st.nextToken();

                if(!map.containsKey(friend1)) {
                    map.put(friend1, friendNum);
                    friendNum++;
                }
                if(!map.containsKey(friend2)) {
                    map.put(friend2, friendNum);
                    friendNum++;
                }
                int rootA = find(map.get(friend1));
                int rootB = find(map.get(friend2));

                union(rootA, rootB);
               sb.append(size[find(rootA)]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int find(int x){
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        if(root1 != root2) {
            parent[root2] = root1;
            size[root1] += size[root2];
        }
    }
}
