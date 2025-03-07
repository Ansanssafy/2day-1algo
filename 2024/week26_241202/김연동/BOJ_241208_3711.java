import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241208_3711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int k = 0; k < N; k++) {
            int G = Integer.parseInt(br.readLine());
            int[] arr = new int[G];
            for (int i = 0; i < G; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int m = 1;
            while (true) {
                boolean isUnique = true;

                for (int i = 0; i < G; i++) {
                    for (int j = i + 1; j < G; j++) {
                        if (arr[i] % m == arr[j] % m) {
                            isUnique = false;
                            break;
                        }
                    }
                    if (!isUnique) break;
                }

                if (isUnique) {
                    sb.append(m).append("\n");
                    break;
                }
                m++;
            }
        }
        System.out.print(sb.toString());
    }
}