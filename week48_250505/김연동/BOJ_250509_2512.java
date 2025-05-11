import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250509_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int left = 0, right = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > right) {
                right = arr[i];
            }
        }

        int M = Integer.parseInt(br.readLine());
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            int money = 0;
            for(int i = 0; i < N; i++) {
                if (arr[i] >= mid) {
                    money += mid;
                } else {
                    money += arr[i];
                }
            }
            if (money > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}
