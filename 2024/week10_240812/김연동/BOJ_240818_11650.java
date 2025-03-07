import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_240818_11650 {
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int [N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (arr1, arr2) -> {

            if(arr1[0] == arr2[0])  {
                return arr1[1] - arr2[1];
            }
            else {
                return arr1[0] - arr2[0];
            }
        });

        for(int i=0; i<N; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }

        System.out.println(sb.toString());
    }
}