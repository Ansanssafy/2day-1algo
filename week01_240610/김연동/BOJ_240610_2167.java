import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240610_2167 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int  i, j, x, y;
		int result;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		
		for(int n = 1; n < N+1; n++) {	
			int index = 1;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				arr[n][index++] = Integer.parseInt(st.nextToken());
			}
		}	
		
		int K = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < K; k++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int p = i; p < x + 1; p++) {
				for(int q = j; q < y + 1; q++) {
					result += arr[p][q];
				}
			}
			System.out.println(result);	
		}
	}
}
