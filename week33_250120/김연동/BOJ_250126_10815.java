import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_250126_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Boolean> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int card;
        for (int i = 0; i < N; i++) {
            card = Integer.parseInt(st.nextToken());
            map.put(card, true);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int temp;
        for (int i = 0; i < M; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (map.containsKey(temp)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}