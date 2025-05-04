import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250430_10431 {
    static int step;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        int[] arr = new int[20];
        for(int p = 1; p <= P; p++) {
            step = 0;
            st = new StringTokenizer(br.readLine());
            int year = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Sort(arr);
            sb.append(year).append(" ").append(step).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void Sort(int[] arr) {
        step = 0;
        int[] sorted = new int[20];

        sorted[0] = arr[0];

        for (int i = 1; i < 20; i++) {
            int now = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] < sorted[j]) {
                    now = j;
                    break;
                }
            }
            for (int j = i; j > now; j--) {
                sorted[j] = sorted[j - 1];
                step++;
            }
            sorted[now] = arr[i];
        }
    }
}
