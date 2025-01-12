import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_250112_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] aArr = new int[N];
        int[] bArr = new int[N];

        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            aArr[index++] = Integer.parseInt(st.nextToken());
        }

        index =0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            bArr[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr);
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += aArr[i] * bArr[(N-1)-i];
        }
        System.out.println(result);
    }
}
