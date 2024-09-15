import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_240915_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> pwd = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pwd.put(st.nextToken(), st.nextToken());
        }
        String line;
        for(int i = 0; i < M; i++) {
            line = br.readLine();
            sb.append(pwd.get(line)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
