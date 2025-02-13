package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_2352_반도체설계 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        lis = new int[N];
        lis[0] = arr[0];
        int p = 1;
        for(int n=1; n<N; n++) {
            if(lis[p-1] < arr[n]) {
                lis[p++] = arr[n];
            } else {
                int idx = binarySearch(p-1, arr[n]);
                lis[idx] = arr[n];
            }
        }
        System.out.println(p);
    }

    public static int binarySearch(int end, int target) {
        int start = 0;
        int mid;
        while(start < end) {
            mid = (start+end)/2;
            if(lis[mid] < target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}