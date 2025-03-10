import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_250309_2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
           }
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        sb.append(arr[0][0] + " " + arr[0][1]).append("\n");
        sb.append(arr[1][0] + " " + arr[1][1]).append("\n");

        int index = 0;
        if(arr[0][0] == arr[1][0]) {
            for(int i = 2; i < N; i++) {
                if(arr[1][0] != arr[i][0]) {
                    index = i;
                    break;
                }
            }
            sb.append(arr[index][0] + " " + arr[index][1]).append("\n");
        }else{
            sb.append(arr[2][0] + " " + arr[2][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}