package Beakjoon.silver;

import java.io.*;
import java.util.*;

public class boj_16967_배열복원하기 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] arrB;
    static int H, W, X, Y;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        arrB = new int[H+X][W+Y];

        for(int r=0; r<H+X; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<W+Y; c++){
                arrB[r][c] = Integer.parseInt(st.nextToken());
            }
        }// 입력 끝

        minusArr();
        for(int r=0; r<H; r++){
            for(int c=0; c<W; c++){
                sb.append(arrB[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void minusArr(){
        for(int r=X; r<X+H; r++){
            for(int c=Y; c<Y+W; c++){
                arrB[r][c] -= arrB[r-X][c-Y];
            }
        }
    }
}
