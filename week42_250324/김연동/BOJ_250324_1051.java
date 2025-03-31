import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250324_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        String line;
        for(int i = 0; i < N; i++) {
            line = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }
        int min = Math.min(M, N);

        int result = 1;
        if (min == 1) {
            System.out.println(1);
        }else {
            for (int len = 2; len <= min; len++) {
                for(int i = 0; i <= N - len; i++) {
                    for(int j = 0; j <= M - len; j++) {
                        if(arr[i][j] == arr[i + (len - 1)][j] && arr[i][j] == arr[i][j + (len - 1)]
                        && arr[i][j] == arr[i + (len - 1)][j + (len - 1)]) {
                            result = len * len;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
