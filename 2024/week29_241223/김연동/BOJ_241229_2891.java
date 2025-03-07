import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241229_2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] kayak = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int index;
        for (int i = 0; i < S; i++) {
            index = Integer.parseInt(st.nextToken());
            kayak[index]--;
        }

        st = new StringTokenizer(br.readLine());
        int index2;
        for (int i = 0; i < R; i++) {
            index2= Integer.parseInt(st.nextToken());
            kayak[index2]++;
        }

        for (int i = 1; i <= N; i++) {
            if (kayak[i] == -1) {
                if (i > 1 && kayak[i - 1] == 1) {
                    kayak[i]++;
                    kayak[i - 1]--;
                } else if (i < N && kayak[i + 1] == 1) {
                    kayak[i]++;
                    kayak[i + 1]--;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (kayak[i] == -1) {
                result++;
            }
        }
        System.out.println(result);
    }
}
