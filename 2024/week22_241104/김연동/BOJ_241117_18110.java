import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_241117_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cut = (int) Math.round(N * 0.15);

        int sum = 0;
        for (int i = cut; i < N - cut; i++) {
            sum += arr[i];
        }
        int temp = N - 2 * cut;

        int result = (int) Math.round((double) sum / temp);
        System.out.println(result);
    }
}
