import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_241222_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        ArrayList<String> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList, Collections.reverseOrder());

        for (String name : sortedList) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
