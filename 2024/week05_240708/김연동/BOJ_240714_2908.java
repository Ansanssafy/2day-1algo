import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240714_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        sb.append(a).reverse();
        sb2.append(b).reverse();

        int result1 = Integer.parseInt(sb.toString());
        int result2 = Integer.parseInt(sb2.toString());
        int resutlt3 = result1 > result2 ? result1 : result2;

        System.out.println(resutlt3);






    }
}
