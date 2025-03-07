import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_240613_2805 {

    public static long getWood(int[] arr, int height) {
        long sum = 0;
        for (int tree : arr) {
            if (tree > height) {
                sum += (tree - height);
            }
        }
        return sum;
    }

    public static int binarySearch(int[] arr, int n, int m) {
        int start = 0;
        int end = arr[n - 1];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long wood = getWood(arr, mid);

            if (wood >= m) {
                result = mid; 
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int result = binarySearch(arr, n, m);
        System.out.println(result);
    }
}
