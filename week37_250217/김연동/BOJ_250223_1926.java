//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.StringTokenizer;
//
//public class BOJ_250223_1926 {
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//    static int N, M;
//    static int[][] arr;
//    static int[][] visited;
//    static int max, quantity;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        arr = new int[N][M];
//        visited = new int[N][M];
//        max = Integer.MIN_VALUE;
//
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < M; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++) {
//                if(arr[i][j] == 1 && visited[i][j] == 0) {
//                    int area = bfs(i, j , 1);
//                    quantity++;
//                    max = Math.max(area, max);
//                }
//            }
//        }
//       if(quantity == 0){
//           System.out.println(0);
//           System.out.println(0);
//       }else{
//           System.out.println(quantity);
//           System.out.println(max);
//       }
//    }
//    static int bfs(int r, int c, int area) {
//        Deque<Node> q = new ArrayDeque<>();
//        q.offerLast(new Node(r, c));
//        visited[r][c] = 1;
//        while(!q.isEmpty()) {
//            Node now = q.pollFirst();
//            for(int k = 0; k < 4; k++) {
//                int nr = now.r + dr[k];
//                int nc = now.c + dc[k];
//                if(nr >= 0 && nc >= 0 && nr < N && nc < M && visited[nr][nc] == 0 && arr[nr][nc] == 1) {
//                    visited[nr][nc] = 1;
//                    q.offerLast(new Node(nr, nc));
//                    area++;
//                }
//            }
//        }
//        return area;
//    }
//}
//class Node {
//    int r;
//    int c;
//    public Node(int r, int c) {
//        this.r = r;
//        this.c = c;
//    }
//}