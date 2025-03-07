package gold;

import java.io.*;
import java.util.*;

public class boj_1922_네트워크연결 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] edges = new int[M][3];
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            edges[m][0] = Integer.parseInt(st.nextToken());
            edges[m][1] = Integer.parseInt(st.nextToken());
            edges[m][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (o1, o2) -> {
            return o1[2]-o2[2];
        });

        p = new int[N+1];
        for(int i=1; i<=N; i++) p[i] = i;
        int cost = 0;
        int select = 0;
        for(int m=0; m<M; m++){
            int px = findSet(edges[m][0]);
            int py = findSet(edges[m][1]);

            if(px!=py){
                union(px, py);
                select++;
                cost += edges[m][2];
            }

            if(select==(N-1)) break;
        }

        System.out.println(cost);
    }

    public static int findSet(int x){
        if( x != p[x]) p[x] = findSet(p[x]);
        return p[x];
    }

    public static void union(int x, int y){
        p[y] = p[x];
    }
}
