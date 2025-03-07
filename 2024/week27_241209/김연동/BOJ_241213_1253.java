import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_241213_1253 {
    static int N;
    static int[] arr;
    static int result = 0;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr= new int[N];
        chk= new boolean[N];
        int index = 0;
        while(st.hasMoreTokens()){
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            Binary(i);
        }
        System.out.println(result);
    }
    public static long Binary(int index) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            if (start == index) {
                start++;
            }
            if (end == index) {
                end--;
            }
            if (start < end) {
                if (arr[start] + arr[end] == arr[index]) {
                    if (chk[index] == false) {
                        result++;
                        chk[index] = true;
                    }
                    return 0;
                } else if (arr[start] + arr[end] > arr[index]) {
                    end--;
                } else if (arr[start] + arr[end] < arr[index]) {
                    start++;
                }
            }
        }
        return -1;
    }
}
