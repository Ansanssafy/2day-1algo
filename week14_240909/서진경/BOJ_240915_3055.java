package gold;

import java.io.*;
import java.util.*;

public class boj_3055_탈출 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static int R, C;
    static char[][] map;
    static int[][] arr;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        arr = new int[R][C];
        queue = new LinkedList<>();

        int[] start = new int[]{0, 0, 1};
        int[] end = new int[]{0, 0};
        for(int r=0; r<R; r++){
            String now = br.readLine();
            for(int c=0; c<C; c++){
                map[r][c]= now.charAt(c);
                if(map[r][c]=='S') {
                    arr[r][c] = 1;
                    map[r][c] = '.';
                    start = new int[]{r, c, 1};
                }
                else if(map[r][c]=='*') queue.add(new int[]{r, c, 0});
                else if(map[r][c]=='D') end = new int[]{r, c};
            }
        }
        queue.add(start);
        bfs();

        int res = arr[end[0]][end[1]];
        if(res==0) System.out.println("KAKTUS");
        else System.out.println(res-1);
    }
    public static void bfs(){
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int d=0; d<4; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]!='X'){
                    if(now[2]==0 && map[nr][nc]!='D' && map[nr][nc]=='.'){
                        map[nr][nc] = '*';
                        queue.add(new int[]{nr, nc, 0});
                    } else if (now[2]==1 && (map[nr][nc]=='.'||map[nr][nc]=='D') && arr[nr][nc]==0){
                        queue.add(new int[]{nr, nc, 1});
                        arr[nr][nc] = arr[now[0]][now[1]]+1;
                        if(map[nr][nc]=='D') return;
                    }
                }
            }
        }
    }
}

