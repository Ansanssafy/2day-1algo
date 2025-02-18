package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_1238_파티 {
    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<int[]>[] adjList, radjList;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        radjList = new ArrayList[N+1];
        for(int n=0; n<=N; n++) {
            adjList[n] = new ArrayList<>();
            radjList[n] = new ArrayList<>();
        }

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, w});
            radjList[b].add(new int[]{a, w});
        }

        int[] go = dijkstra(X, true);
        int[] back = dijkstra(X, false);

        int max = -1;
        for(int n=1; n<=N; n++) {
            max = Math.max(max, go[n]+back[n]);
        }

        System.out.println(max);
    }

    public static int[] dijkstra(int start, boolean go) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq  = new PriorityQueue<>((o1, o2) -> {
            return o1[1]-o2[1];
        });
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            for(int[] next : go? adjList[now[0]] : radjList[now[0]]) {
                if(dist[next[0]] > dist[now[0]] + next[1]) {
                    dist[next[0]] = dist[now[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        return dist;
    }
}
