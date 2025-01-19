import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250113_17266 {
    static int[] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = N;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (chk(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
    private static boolean chk(int temp) {
        int prev = 0;
        for(int i = 0; i < arr.length; i++ ) {
            if(arr[i] - temp <= prev){
                prev = arr[i] + temp;
            }else{
                return false;
            }
        }
        return N - prev <= 0;
    }
}
