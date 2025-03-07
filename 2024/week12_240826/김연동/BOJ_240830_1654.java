import java.util.*;
import java.io.*;

public class BOJ_240830_1654 {
    static int search;
    static long max = 0;
    static int[] arr;
    static int K;
    static int N;
    static long mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(Binary(arr[K-1]));
    }

    private static long Binary(int search) {
        long start = 1;
        long end = search;

        while (start <= end) {
            mid = (start + end) / 2;
            int temp = 0;

            for (int i = 0; i < K; i++) {
                temp += (arr[i] / mid);
            }

            if (temp >= N) {
                max = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return max;
    }
}
