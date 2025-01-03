package Beakjoon.silver;

import java.io.*;
import java.util.*;

public class boj_17086_아기상어2 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static int N, M;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        queue = new LinkedList<>();
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c] == 1) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        System.out.println(bfs()-1);
    }

    public static int bfs() {
        int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dc = {0, 1, 0, -1, -1, 1, -1, 1};

        int max = -1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int d=0; d<8; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==0){
                    arr[nr][nc] = arr[now[0]][now[1]]+1;
                    queue.add(new int[]{nr, nc});
                    max = Math.max(max, arr[nr][nc]);
                }
            }
        }

        return max;
    }
}
