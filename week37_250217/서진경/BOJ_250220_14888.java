package beakjoon.silver;

import java.io.*;
import java.util.*;

public class boj_14888_연산자끼워넣기 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] arr, operator, select;
    static int N, max, min;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int o=0; o<4; o++) {
            operator[o] = Integer.parseInt(st.nextToken());
        }

        select = new int[N-1];
        min = 1000000000;
        max = -1000000000;
        find(0);

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    public static void find(int now) {
        if(now==N-1) {
            int res = arr[0];
            for(int n=1; n<N; n++) {
                res = calc(select[n-1], res, arr[n]);
            }
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        for(int o=0; o<4; o++) {
            if(operator[o]==0) continue;
            select[now] = o;
            operator[o]--;
            find(now+1);
            operator[o]++;
        }
    }

    public static int calc(int type, int a, int b) {
        int res;
        if(type==0){
            res = a+b;
        } else if (type==1) {
            res = a-b;
        } else if(type==2) {
            res = a*b;
        } else {
            res = a/b;
        }
        return res;
    }
}
