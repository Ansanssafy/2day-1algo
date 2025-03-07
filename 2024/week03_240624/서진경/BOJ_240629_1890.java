package silver;

import java.io.*;
import java.util.*;

public class boj_1890_점프 {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		long[][] dp = new long[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		
		dp[0][0] = 1;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int value = board[r][c];
				if(value==0) continue;
				if(r+value<N) dp[r+value][c] += dp[r][c];
				if(c+value<N) dp[r][c+value] += dp[r][c];
			}
		}
		
		System.out.println(dp[N-1][N-1]);
	}
}
