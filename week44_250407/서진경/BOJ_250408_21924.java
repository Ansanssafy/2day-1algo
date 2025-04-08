package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_21924_도시건설 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N+1];
        for(int n=0; n<=N; n++) {
            p[n] = n;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2]-o2[2];
        });

        long total = 0;
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b, c});
            total += c;
        }

        long w = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int pa = findP(now[0]);
            int pb = findP(now[1]);

            if(pa!=pb) {
                union(pa, pb);
                w += now[2];
                cnt++;
            }

            if(cnt == N-1) break;
        }

        long res = total-w;
        if(cnt < N-1) res = -1;

        System.out.println(res);
    }

    static int findP(int x) {
        if(x != p[x]) p[x] = findP(p[x]);
        return p[x];
    }

    static void union(int x, int y) {
        p[y] = p[x];
    }
}
