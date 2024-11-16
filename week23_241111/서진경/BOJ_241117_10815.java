package silver;

import java.io.*;
import java.util.*;

public class boj_10815_숫자카드 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean[] cards = new boolean[20000001];
        for(int n=0; n<N; n++){
            int now = Integer.parseInt(st.nextToken())+10000000;
            cards[now] = true;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            int target = Integer.parseInt(st.nextToken())+10000000;
            sb.append(cards[target] ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}
