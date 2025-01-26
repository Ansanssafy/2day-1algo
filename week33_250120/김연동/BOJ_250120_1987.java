import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250120_1987 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] board;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i=0; i<R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        result = 0;
        visited = new boolean[26];
        dfs(0,0, 1);
        System.out.println(result);
    }
    static void dfs(int row, int col, int len) {
        result = Math.max(result, len);
        visited[board[row][col] - 'A'] = true;
        for(int k = 0; k < 4; k++) {
            int nr = row + dr[k];
            int nc = col + dc[k];
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && !visited[board[nr][nc] - 'A']) {
                dfs(nr, nc, len + 1);
            }
        }
        visited[board[row][col] - 'A'] = false;
    }
}
