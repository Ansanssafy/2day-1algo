import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241013_4884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            long G = Long.parseLong(st.nextToken());
            long T = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long D = Long.parseLong(st.nextToken());

            if (G == -1 && T == -1 && A == -1 && D == -1) {
                break;
            }

            long team = G * A + D;

            long temp = 1;
            while (temp < team) {
                temp *= 2;
            }
            long totalTeam = temp - team;

            long totalGame = temp - 1;
            long groupGame = (T * (T - 1)) / 2 * G;

            sb.append(String.format("%d*%d/%d+%d=%d+%d\n", G, A, T, D, groupGame + totalGame, totalTeam));
        }
        System.out.println(sb.toString());
    }
}
