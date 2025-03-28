package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_2212_센서 {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] interval = new int[N-1];
        for(int n=1; n<N; n++) {
            interval[n-1] = arr[n]-arr[n-1];
        }
        Arrays.sort(interval);

        int res = 0;
        for(int n=0; n<N-K; n++) {
            res += interval[n];
        }

        System.out.println(res);
    }
}
