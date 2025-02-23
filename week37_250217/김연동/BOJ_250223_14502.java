//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//public class BOJ_250223_14502 {
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//    static int N, M;
//    static int[][] arr;
//    static int[][] temp;
//    static int[][] visited;
//    static int result;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        arr = new int[N][M];
//        visited = new int[N][M];
//        int index;
//        for(int i = 0; i < N; i++){
//            index = 0;
//            st = new StringTokenizer(br.readLine());
//            while(st.hasMoreTokens()){
//                arr[i][index++] = Integer.parseInt(st.nextToken());
//            }
//        }
//        dfs(0);
//        System.out.println(result);
//    }
//
//    static void dfs(int wall){
//        if(wall == 3){
//            virus();
//            return;
//        }
//        // 벽 확인
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                if(arr[i][j] == 0){
//                    arr[i][j] = 1;
//                    dfs(wall+1);
//                    arr[i][j] = 0;
//                }
//            }
//        }
//    }
//
//    static void virus(){
//        temp = new int[N][M];
//        for(int i = 0; i < N; i++){
//            System.arraycopy(arr[i], 0, temp[i], 0, M);
//        }
//        visited = new int[N][M];
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                if(temp[i][j] == 2 && visited[i][j] == 0){
//                    bfs(i,j);
//                }
//            }
//        }
//        int safety = 0;
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                if(temp[i][j] == 0){
//                    safety++;
//                }
//            }
//        }
//        result = Math.max(safety, result);
//    }
//
//    static void bfs(int i, int j){
//        Deque<Node> q = new ArrayDeque<Node>();
//        visited[i][j] = 1;
//        q.offerLast(new Node(i,j));
//
//        while(!q.isEmpty()){
//            Node now =  q.pollFirst();
//            for(int k = 0; k < 4; k++){
//                int nr = now.r + dr[k];
//                int nc = now.c + dc[k];
//                if(nr >= 0 && nc >= 0 && nr < N && nc < M && visited[nr][nc] == 0 && arr[nr][nc] == 0){
//                    visited[nr][nc] = 1;
//                    temp[nr][nc] = 2;
//                    q.offerLast(new Node(nr,nc));
//                }
//            }
//        }
//    }
//}
//class Node{
//    int r;
//    int c;
//    public Node(int r, int c){
//        this.r = r;
//        this.c = c;
//    }
//}
