import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250513_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] burger = new boolean[N];
        char[] arr = new char[N];

        String line = br.readLine();
        for(int i = 0; i < N; i++) {
            arr[i] = line.charAt(i);
            if(arr[i] == 'P') {
                burger[i] = true;
            }
        }
        int result = 0;
        for(int i = 0; i < N; i++) {
            start : if(arr[i] == 'P'){
                for(int j = K; j > 0; j--) {
                    if(i-j >= 0 && !burger[i-j]) {
                        burger[i-j] = true;
                        result++;
                        break start;
                    }
                }
                for(int j = 1; j <= K; j++) {
                    if(i+j < N && !burger[i+j]) {
                        burger[i+j] = true;
                        result++;
                        break start;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
