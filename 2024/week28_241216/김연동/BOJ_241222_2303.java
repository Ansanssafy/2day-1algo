import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241222_2303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int maxPlayer = 0;
        int maxScore = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int currentMax = 0;
            for (int a = 0; a < 5; a++) {
                for (int b = a + 1; b < 5; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = arr[a] + arr[b] + arr[c];
                        currentMax = Math.max(currentMax, sum % 10);
                    }
                }
            }

            if (currentMax >= maxScore) {
                maxScore = currentMax;
                maxPlayer = i;
            }
        }

        System.out.println(maxPlayer);
    }
}
