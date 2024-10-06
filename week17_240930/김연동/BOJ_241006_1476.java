import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241006_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;
        int count = 1;

        while(e != E || m != M || s != S) {
            count++;
            e = (e % 15) + 1;
            s = (s % 28) + 1;
            m = (m % 19) + 1;
        }
        System.out.println(count);
    }
}
