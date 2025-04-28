import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_250423_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N, score, temp, index;
        int[][] arr;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[2][N];
            index = 0;
            while (st.hasMoreTokens()) {
                temp = Integer.parseInt(st.nextToken());
                arr[0][index++] = temp;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }

            score = 1;
            for (int i = 0; i < N; i++) {
                if (map.get(arr[0][i]) == 6) {
                    arr[1][i] = score++;
                }
            }

            HashMap<Integer, ArrayList<Integer>> teamScores = new HashMap<>();

            for (int i = 0; i < N; i++) {
                if (map.get(arr[0][i]) == 6) {
                    teamScores.putIfAbsent(arr[0][i], new ArrayList<>());
                    teamScores.get(arr[0][i]).add(arr[1][i]);
                }
            }

            int result = 0;
            int min = Integer.MAX_VALUE;
            int teamfifth = Integer.MAX_VALUE;

            for (int team : teamScores.keySet()) {
                ArrayList<Integer> list = teamScores.get(team);
                Collections.sort(list);

                int sum = list.get(0) + list.get(1) + list.get(2) + list.get(3);
                int fifth = list.get(4);

                if (sum < min) {
                    min = sum;
                    teamfifth = fifth;
                    result = team;
                } else if (sum == min && fifth < teamfifth) {
                    teamfifth = fifth;
                    result = team;
                }
            }
            sb.append(result).append("\n");
            map.clear();
        }
        System.out.println(sb.toString());
    }
}