import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250302_2508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int result, r, c;
        for(int i = 0; i < t; i++) {
            result = 0;
            br.readLine();
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            char[][] arr = new char[r][c];
            for(int j = 0; j < r; j++) {
                String line = br.readLine();
                arr[j] = line.toCharArray();
            }
            for(int j = 0; j < r; j++) {
                for(int k = 0; k < c; k++) {
                    if(k < c-2 && arr[j][k] == '>' && arr[j][k+1] == 'o' && arr[j][k+2] == '<') {
                        result++;
                    }
                    if(j < r-2 && arr[j][k] == 'v' && arr[j+1][k] == 'o' && arr[j+2][k] == '^') {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}