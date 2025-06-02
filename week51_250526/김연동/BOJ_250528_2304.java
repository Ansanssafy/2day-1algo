import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250528_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] height = new int[1001];
        int maxHeight = 0;
        int maxIdx = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            height[L] = H;

            if (H > maxHeight) {
                maxHeight = H;
                maxIdx = L;
            }
        }

        int result = maxHeight;
        int temp = 0;

        for (int i = 0; i < maxIdx; i++) {
            if (height[i] > temp) {
                temp = height[i];
            }
            result += temp;
        }
        temp = 0;
        for (int i = 1000; i > maxIdx; i--) {
            if (height[i] > temp) {
                temp = height[i];
            }
            result += temp;
        }
        System.out.println(result);
    }
}