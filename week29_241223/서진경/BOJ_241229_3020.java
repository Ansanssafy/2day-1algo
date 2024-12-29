package Beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_3020_개똥벌레 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] cave = new int[H+1];
        for(int n=0; n<N; n++){
            int size = Integer.parseInt(br.readLine());
            if(n%2==0){
                cave[0] += 1;
                cave[size] -= 1;
            } else {
                cave[H-size] += 1;
            }
        } // 입력 끝

        int min = cave[0];
        int cnt = 1;
        for(int h=1; h<H; h++){
            cave[h] += cave[h-1];

            if(cave[h] < min) {
                min = cave[h];
                cnt = 1;
            } else if (cave[h] == min){
                cnt++;
            }
        }

        sb.append(min).append(" ").append(cnt);
        System.out.println(sb);
    }
}
