import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241212_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int index = 0;
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        boolean[] chk = new boolean[N];
        int result = 0;
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(arr[i] + arr[j] == M && chk[i] == false && chk[j] == false){
                    result++;
                    chk[i] = true;
                    chk[j] = true;
                }
            }
        }
        System.out.println(result);
    }
}
