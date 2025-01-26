import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_250126_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Boolean> map = new HashMap<>();
        map.put("ChongChong", true);

        String personA;
        String personB;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            personA = st.nextToken();
            personB = st.nextToken();

            if (map.getOrDefault(personA, false) || map.getOrDefault(personB, false)) {
                map.put(personA, true);
                map.put(personB, true);
            }
        }
        int result = 0;
        for (boolean dance : map.values()) {
            if (dance) {
                result++;
            }
        }
        System.out.println(result);
    }
}
