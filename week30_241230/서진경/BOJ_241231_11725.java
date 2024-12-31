package Beakjoon.silver;

import java.io.*;
import java.util.*;

public class boj_11725_트리의부모찾기 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adjList;
    static int[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int n=0; n<N-1; n++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited = new int[N+1];
        visited[1] = -1;

        findParent();
        for(int n=2; n<=N; n++){
            sb.append(visited[n]).append("\n");
        }
        System.out.println(sb);
    }

    public static void findParent(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int p = queue.poll();

            for(int now : adjList[p]){
                if(visited[now]!=0) continue;
                visited[now] = p;
                queue.add(now);
            }
        }
    }
}
