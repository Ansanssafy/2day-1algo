package silver;

import java.io.*;
import java.util.*;

public class boj_2606_바이러스 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] adjArr;
	static boolean[] check;
	static int V, E, cnt;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		adjArr = new int[V+1][V+1];
		check=  new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjArr[A][B] = 1;
			adjArr[B][A] = 1;
		}
		
		check[1] = true;
		cnt = 0;
		for(int i=2; i<=V; i++) {
			if(adjArr[1][i]==1) dfs(i);
		}
		
		System.out.println(cnt);
		
	}
	
	static void dfs(int x) {
		if(!check[x]) {
			check[x] = true;
			cnt++;
			for(int i=2; i<=V; i++) {
				if(adjArr[x][i]==1) dfs(i);
			}
		}
	}

}
