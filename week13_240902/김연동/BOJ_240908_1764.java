import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_240908_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> nolisten = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nolisten.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            // 듣보잡 추가
            if (nolisten.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}