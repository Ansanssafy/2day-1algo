import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240804_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[20000001];

        st = new StringTokenizer(br.readLine());
        int num;

        for(int i = 0; i < N; i++){
            num = Integer.parseInt(st.nextToken());
            count[num + 10000000] += 1;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int test;
        while(st.hasMoreTokens()){
            test = Integer.parseInt(st.nextToken());
            sb.append(count[test+ 10000000]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
