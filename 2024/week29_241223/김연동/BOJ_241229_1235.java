import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_241229_1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int k = 1;

        while (true) {
            HashSet<String> set = new HashSet<>();
            boolean isUnique = true;

            for (String num : arr) {
                String suffix = num.substring(num.length() - k);
                if (!set.add(suffix)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                System.out.println(k);
                break;
            }
            k++;
        }
    }
}