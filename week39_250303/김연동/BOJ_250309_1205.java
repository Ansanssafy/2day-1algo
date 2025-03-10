import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250309_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

       int[] arr = new int[N];
       int rank = 1;

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } else {
            System.out.println(1);
            return;
        }

       if(N == P && score <= arr[arr.length - 1]) {
           sb.append("-1");
       }else{
           for(int i = 0; i < arr.length; i++) {
               if(score < arr[i]) {
                   rank++;
               }else{
                   break;
               }
           }
           sb.append(rank);
       }
        System.out.println(sb.toString());
    }
}