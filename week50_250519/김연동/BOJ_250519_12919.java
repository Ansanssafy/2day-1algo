import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250519_12919 {
    static String S;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        String T = br.readLine();

        dfs(T);
        System.out.println(result);
    }

    static void dfs(String t) {
        if (t.length() == S.length()) {
            if (t.equals(S)) {
                result = 1;
            }
            return;
        }

        if (t.endsWith("A")) {
            dfs(t.substring(0, t.length() - 1));
        }

        if (t.startsWith("B")) {
            StringBuilder sb = new StringBuilder(t.substring(1)).reverse();
            dfs(sb.toString());
        }
    }
}
