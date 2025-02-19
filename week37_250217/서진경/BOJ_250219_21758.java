package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_21758_꿀따기 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] honey;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        honey = new int[3][N+2];
        for(int n=1; n<=N; n++) {
            honey[0][n] = Integer.parseInt(st.nextToken());
            honey[1][n] = honey[1][n-1] + honey[0][n];
        }

        for(int n=N; n>=1; n--) {
            honey[2][n] = honey[2][n+1] + honey[0][n];
        }

        System.out.println(findMax());
    }

    public static int findMax() {
        int maxR = -1;
        int maxL = -1;
        int maxM = -1;
        for(int n=2; n<N; n++) {
            int right = honey[1][N]-honey[1][n]-honey[0][n];
            int left = honey[2][1]-honey[2][n]-honey[0][n];
            int mid = honey[1][n] + honey[2][n];
            maxR = Math.max(maxR, right);
            maxL = Math.max(maxL, left);
            maxM = Math.max(maxM, mid);
        }

        int resR = honey[1][N] - honey[0][1] + maxR;
        int resL = honey[2][1] - honey[0][N] + maxL;
        int resM = maxM-honey[0][1]-honey[0][N];

        return Math.max(Math.max(resL, resR), resM);
    }

}
