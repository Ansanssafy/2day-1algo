package Beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_16236_아기상어 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static int[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int[] shark = new int[5]; // R, C, SIZE, EAT, SEC
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c]==9){
                    shark[0] = r;
                    shark[1] = c;
                    shark[2] = 2;
                    shark[3] = 0;
                    shark[4] = 0;
                    arr[r][c] = 0;
                }
            }
        }

        boolean possible = checkFish(2);
        while(possible){
            int[] result = bfs(shark);
            if(result[0]==999) break;

            shark[0] = result[0];
            shark[1] = result[1];
            shark[4] += result[2];
            shark[3]++;
            if(shark[2]==shark[3]){
                shark[2]++; // 사이즈 up
                shark[3] = 0; // 먹은 개수 초기화
            }
            possible = checkFish(shark[2]);
        }

        System.out.println(shark[4]);
    }

    public static int[] bfs(int[] shark){
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        visited = new int[N][N];
        visited[shark[0]][shark[1]] = 1;
        queue.add(new int[]{shark[0], shark[1]});
        int[] result = {999, 999, 0};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s=0; s<size; s++){
                int[] now = queue.poll();

                if((now[0] != shark[0] || now[1] != shark[1]) &&
                        arr[now[0]][now[1]] != 0 && arr[now[0]][now[1]] < shark[2]) {
                    if (result[0] > now[0] || (result[0] == now[0] && result[1] > now[1])) {
                        result[0] = now[0];
                        result[1] = now[1];
                        result[2] = visited[now[0]][now[1]] - 1;
                    }
                }

                for(int d=0; d<4; d++){
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];
                    if(nr >= 0 && nr<N && nc>=0 && nc<N && visited[nr][nc] == 0 && arr[nr][nc] <= shark[2]){
                        visited[nr][nc] = visited[now[0]][now[1]]+1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }

            if(result[0]!=999){
                arr[result[0]][result[1]] = 0;
                break;
            }
        }
        return result;
    }

    public static boolean checkFish(int size){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c] != 0 && arr[r][c] < size) return true;
            }
        }
        return false;
    }
}
