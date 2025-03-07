import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_241020_2238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int U = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<String>[] list = new ArrayList[10001];
        int[] num = new int[10001];

        for (int i = 0; i < 10001; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            list[price].add(name);
            num[price]++;
        }

        int m = 10001;

        for (int i = 0; i < 10001; i++) {
            if (num[i] != 0) {
                m = Math.min(m, num[i]);
            }
        }

        for (int i = 0; i < 10001; i++) {
            if (num[i] == m) {
                System.out.println(list[i].get(0) + " " + i);
                break;
            }
        }
    }
}
