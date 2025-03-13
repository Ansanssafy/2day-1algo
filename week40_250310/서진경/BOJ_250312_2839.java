package beakjoon.silver;

import java.io.*;
import java.util.*;

public class boj_2839_설탕배달 {
    static BufferedReader br;
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[5001];
        arr[3] = 1;
        arr[5] = 1;

        bfs();
        int res = arr[N];
        if(res==0) res = -1;
        System.out.println(res);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(5);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now+3 <= N && (arr[now+3]==0 || arr[now+3] > arr[now]+1)) {
                queue.add(now+3);
                arr[now+3] = arr[now]+1;
            }
            if(now+5 <= N && (arr[now+5]==0 || arr[now+5] > arr[now]+1)) {
                queue.add(now+5);
                arr[now+5] = arr[now]+1;
            }
        }
    }
}
