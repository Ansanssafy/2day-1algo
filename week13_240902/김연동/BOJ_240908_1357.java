import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240908_1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3;

        String X = st.nextToken();
        String Y = st.nextToken();

        sb.append(X).reverse();
        int result1 = Integer.parseInt(sb.toString());

        sb2.append(Y).reverse();
        int result2 = Integer.parseInt(sb2.toString());
        int result3 = result1 + result2;

        sb3 = new StringBuilder(String.valueOf(result3)).reverse();
        System.out.println(Integer.parseInt(sb3.toString()));
    }
}
