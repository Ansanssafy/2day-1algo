package silver;

import java.io.*;
import java.util.*;

public class boj_11055_가장긴증가하는부분수열 {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[][] arr = new int[2][N];
        arr[1][0] = 1;
        int res = 0;
        for(int i=0; i<N; i++){
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = arr[0][i];
            for(int j=i; j>=0; j--){
                if(arr[0][j] < arr[0][i]) arr[1][i] = Math.max(arr[1][i], arr[1][j]+arr[0][i]);
            }
            res = Math.max(res, arr[1][i]);
        }
        System.out.println(res);
    }
}
