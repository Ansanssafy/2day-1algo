import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240929_3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int star = Integer.parseInt(br.readLine());
        int[] arr = new int[star];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int click = Math.abs(A - B);

        for (int i = 0; i < arr.length; i++) {
            int pressCount = 1 + Math.abs(arr[i] - B);
            click = Math.min(click, pressCount);
        }
        System.out.println(click);
    }
}