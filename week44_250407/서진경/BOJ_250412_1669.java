package beakjoon.gold;

import java.io.*;
import java.util.*;

public class boj_1669_멍멍이쓰다듬기 {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        if(X==Y) {
            System.out.println(0);
            return;
        }

        long target = Y-X;
        long cm = 1;
        while(cm*cm <= target) {
            cm++;
        }
        cm--;

        long res = cm*2-1;
        target -= cm*cm;
        while(target > 0) {
            target -= Math.min(cm, target);
            res++;
        }
        System.out.println(res);
    }
}
