package bronze;

import java.io.*;

public class boj_4504_배수찾기 {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int now = Integer.parseInt(br.readLine());;
		while(now != 0) {
			if(now%N==0) sb.append(now).append(" is a multiple of ").append(N).append(".\n");
			else sb.append(now).append(" is NOT a multiple of ").append(N).append(".\n");
			now = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}
}
