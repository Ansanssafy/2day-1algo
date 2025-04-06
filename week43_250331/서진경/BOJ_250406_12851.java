package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_12851_숨바꼭질2 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] visited;
    static int N, K;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        visited[N] = 1;
        bfs();
        System.out.println(sb);
    }

    static void bfs() {
        int[] dn = {-1, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 1});

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[1] > min) continue;

            if(now[0]==K) {
                if(now[1] < min) {
                    min = now[1];
                    cnt = 1;
                } else {
                    cnt++;
                }
                continue;
            }

            for(int d=0; d<3; d++) {
                int next = now[0] + dn[d];
                if(d==2) next = now[0]*2;

                if(next >= 0 && next <= 100000 && (visited[next]==0 || visited[next]==now[1]+1)) {
                    queue.add(new int[]{next, now[1]+1});
                    visited[next] = now[1]+1;
                }
            }
        }

        sb.append(min-1).append("\n").append(cnt);
    }
}
