//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.Deque;
//import java.util.StringTokenizer;
//
//public class BOJ_250223_14940 {
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//    static int N, M;
//    static int[][] arr;
//    static int[][] visited;
//    static int startR, startC;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        arr = new int[N][M];
//        visited = new int[N][M];
//
//        for(int i=0; i<N; i++) {
//            Arrays.fill(visited[i], -1);
//        }
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//                if (arr[i][j] == 2) {
//                    startR = i;
//                    startC = j;
//                }
//            }
//        }
//        bfs(startR,startC,0);
//        for(int i=0; i<N; i++) {
//            for(int j=0; j<M; j++) {
//                if (arr[i][j] == 0) {
//                    sb.append("0").append(" ");
//                } else {
//                    sb.append(visited[i][j]).append(" ");
//                }
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb.toString());
//    }
//    static void bfs(int startR, int startC, int depth) {
//        Deque<Node> q = new ArrayDeque<>();
//        q.offerLast(new Node(startR, startC, depth));
//        visited[startR][startC] = 0;
//        while(!q.isEmpty()) {
//            Node now =q.pollFirst();
//            for(int k = 0; k < 4; k++) {
//                int nr = now.r + dr[k];
//                int nc = now.c + dc[k];
//                if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
//                    if(arr[nr][nc] != 0 && visited[nr][nc] == -1) {
//                        visited[nr][nc] = now.depth + 1;
//                        q.offerLast(new Node(nr, nc, now.depth + 1));
//                    }
//                }
//            }
//        }
//    }
//}
//class Node{
//    int r;
//    int c;
//    int depth;
//    public Node(int r, int c, int depth) {
//        this.r = r;
//        this.c = c;
//        this.depth = depth;
//    }
//}