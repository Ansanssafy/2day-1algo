package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_1600_말이되고픈원숭이 {
    static BufferedReader br;
    static StringTokenizer st;
    static Queue<int[]> queue;
    static int[][][] visited;
    static int[][] arr;
    static int W, H, K;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        visited = new int[H][W][K+1];
        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W; w++) {
                arr[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs()-1);
    }

    public static int bfs() {
        queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0]==H-1 && now[1]==W-1) return visited[now[0]][now[1]][now[2]];

            // 1. 원숭이 이동
            move(now, 0, 4, false);

            // 2. 말 이동
            if(now[2] >= K) continue;
            move(now, 4, 12, true);
        }

        return 0;
    }

    public static void move(int[] now, int st, int ed, boolean isHorse) {
        int[] dr = {1, 0, -1, 0, 1, 2, 2, 1, -1, -2, -2, -1};
        int[] dc = {0, 1, 0, -1, 2, 1, -1, -2, 2, 1, -1, -2};

        int cnt = isHorse ? now[2]+1 : now[2];
        for(int d=st; d<ed; d++){
            int nr = now[0] + dr[d];
            int nc = now[1] + dc[d];
            if (nr >= 0 && nr < H && nc >= 0 && nc < W && arr[nr][nc] != 1
                    && visited[nr][nc][cnt]==0) {
                queue.add(new int[]{nr, nc, cnt});
                visited[nr][nc][cnt] = visited[now[0]][now[1]][now[2]] + 1;
            }
        }
    }
}
