//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//public class BOJ_250223_1012 {
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//    static int M, N, K;
//    static int result;
//    static boolean[][] visited;
//    static StringBuilder sb = new StringBuilder();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int T = Integer.parseInt(br.readLine());
//        for(int tc = 0; tc < T; tc++){
//            st = new StringTokenizer(br.readLine());
//            M = Integer.parseInt(st.nextToken());
//            N = Integer.parseInt(st.nextToken());
//            K = Integer.parseInt(st.nextToken());
//            visited = new boolean[M][N];
//            int r, c;
//            for(int k = 0; k < K; k++){
//                st = new StringTokenizer(br.readLine());
//                r = Integer.parseInt(st.nextToken());
//                c = Integer.parseInt(st.nextToken());
//                visited[r][c] = true;
//            }
//            result = 0;
//            for(int i = 0; i < M; i++){
//                for(int j = 0; j < N; j++) {
//                    if (visited[i][j]) {
//                        result++;
//                        bfs(i, j);
//                    }
//                }
//            }
//            sb.append(result).append("\n");
//        }
//        System.out.println(sb.toString());
//    }
//    static void bfs(int r, int c){
//        visited[r][c] = false;
//        Deque<Node> q = new ArrayDeque<Node>();
//        q.offerLast(new Node(r, c));
//        while(!q.isEmpty()){
//            Node now = q.pollFirst();
//            for(int i = 0; i < 4; i++){
//                int nr = now.r + dr[i];
//                int nc = now.c + dc[i];
//                if(nr >= 0 && nc >= 0 && nr < M && nc < N && visited[nr][nc]){
//                    q.offerLast(new Node(nr, nc));
//                    visited[nr][nc] = false;
//                }
//            }
//        }
//    }
//}
//class Node {
//    int r;
//    int c;
//    public Node(int r, int c){
//        this.r = r;
//        this.c = c;
//    }
//}
