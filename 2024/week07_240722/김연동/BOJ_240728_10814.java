import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_240728_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int age;
        String name;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<String>> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();

            if (!map.containsKey(age)) {
                map.put(age, new ArrayList<>());
            }
            map.get(age).add(name);
        }

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            age = entry.getKey();
            List<String> names = entry.getValue();
            for (String result : names) {
                System.out.println(age + " " + result);
            }
        }
    }
}