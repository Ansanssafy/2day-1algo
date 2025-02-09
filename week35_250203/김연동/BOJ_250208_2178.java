import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_250208_2178 {
    static int N, M, result;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        String line;
        for(int i = 0; i < N; i++) {
            line = br.readLine();
            map[i] = line.toCharArray();
        }
        result = Integer.MAX_VALUE;
        bfs(0, 0, 1);
        System.out.println(result);
    }
    static void bfs(int r, int c, int depth) {
        visited = new boolean[N][M];
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(r,c,depth));
        visited[r][c] = true;
        while(!q.isEmpty()) {
            Node now = q.pollFirst();
            for(int k = 0; k < 4; k++) {
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == '1') {
                    q.offerLast(new Node(nr,nc, now.depth + 1));
                    visited[nr][nc] = true;
                    if(nr == N - 1 && nc == M - 1) {
                        if(depth < result) {
                            result = now.depth + 1;
                        }
                    }
                }
            }
        }
    }
}

class Node {
    int r;
    int c;
    int depth;
    public Node(int r, int c, int depth) {
        this.r = r;
        this.c = c;
        this.depth = depth;
    }
}
