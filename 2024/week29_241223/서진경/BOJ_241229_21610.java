package Beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_21610_마법사상어와비바라기 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] basket;
    static boolean[][] visited;
    static int N;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        basket = new int[N][N];
        visited = new boolean[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                basket[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        queue = new LinkedList<>();
        queue.add(new int[]{N-1, 0});
        queue.add(new int[]{N-1, 1});
        queue.add(new int[]{N-2, 0});
        queue.add(new int[]{N-2, 1});

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            magic(d, s%N);
        }

        int res = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                res += basket[r][c];
            }
        }
        System.out.println(res);
    }

    public static void magic(int d, int s){
        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

        // 1~2단계
        boolean[][] visited = new boolean[N][N];
        int size = queue.size();
        for(int i=0; i<size; i++){
            int[] now = queue.poll();
            int r = now[0] + dr[d]*s;
            int c = now[1] + dc[d]*s;
            r = checkRC(r);
            c = checkRC(c);

            basket[r][c]++;
            visited[r][c] = true;
            queue.add(new int[]{r, c});
        }

        // 4단계
        for(int i=0; i<size; i++){
            int[] now = queue.poll();
            int cnt = checkDiagonal(now[0], now[1]);
            basket[now[0]][now[1]]+=cnt;
        }

        // 5단계
        addCloud(visited);
    }

    public static int checkRC(int target){
        if(target>0){
            target %= N;
        } else if (target<0){
            target += N;
        }
        return target;
    }

    public static int checkDiagonal(int r, int c){
        int[] dr = {-1, -1, 1, 1};
        int[] dc = {-1, 1, -1, 1};

        int res = 0;
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr>=0 && nr<N && nc>=0 && nc<N && basket[nr][nc]>0) res++;
        }

        return res;
    }

    public static void addCloud(boolean[][] visited){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(basket[r][c]>=2 && !visited[r][c]) {
                    basket[r][c] -= 2;
                    if(basket[r][c] < 0) basket[r][c] = 0;
                    queue.add(new int[]{r, c});
                }
            }
        }
    }
}
