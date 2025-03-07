import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_240829_1920 {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int index = 0;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        index = 0;
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int temp;
        for(int i = 0; i < M; i++) {
            temp = Integer.parseInt(st.nextToken());
            sb.append(Binary(temp)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int Binary(int temp) {
        int start = 0;
        int end = N - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == temp) {
                return 1;
            }else if(arr[mid] > temp) {
                end = mid - 1;
            }else if(arr[mid] < temp) {
                start = mid + 1;
            }
        }
        return 0;
    }
}
