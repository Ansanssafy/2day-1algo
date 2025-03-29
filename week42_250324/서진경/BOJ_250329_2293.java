package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_2293_동전1 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] arr, memo;
    static int N, K;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        memo = new int[K+1];
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        dp();
        System.out.println(memo[K]);
    }

    static void dp() {
        for(int n=0; n<N; n++) {
            if(arr[n] > K) continue;
            memo[arr[n]]++;
            for(int k=arr[n]; k<=K; k++) {
                memo[k] += memo[k-arr[n]];
            }
        }
    }
}
