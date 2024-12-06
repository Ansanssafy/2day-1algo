import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241201_5046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] hotel = new int[h];
        int[] minCost = new int[h];

        for (int i = 0; i < h; i++) {
            hotel[i] = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int room = Integer.parseInt(st.nextToken());
                if (room >= n) {
                    if (hotel[i] * n < min) {
                        min = hotel[i] * n;
                    }
                }
                minCost[i] = min;
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < minCost.length; i++) {
            if (minCost[i] < min) {
                min = minCost[i];
            }
        }
        if (min > b) {
            System.out.println("stay home");
        } else {
            System.out.println(min);
        }
    }
}

