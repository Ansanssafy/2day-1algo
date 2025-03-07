package Beakjoon.silver;

import java.io.*;
import java.util.*;

public class boj_11441_합구하기 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
            if(n>0) arr[n]+=arr[n-1];
        }

        int M = Integer.parseInt(br.readLine());
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            int res = arr[b];
            if(a>0) res-=arr[a-1];
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
