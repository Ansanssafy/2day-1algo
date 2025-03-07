import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_240908_30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] arr1 = new boolean[200001];
        int[] cArr1 = new int[200001];

        Deque<Integer> q1 = new ArrayDeque<>();

        int count1 = 0; // 과일 종류

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index;
        int result = 0;

        while (st.hasMoreTokens()) {
            index = Integer.parseInt(st.nextToken());
            if (!arr1[index]) {
                count1++;
                arr1[index] = true;
            }

            cArr1[index] += 1;
            q1.offerLast(index);

            while (count1 > 2) {
                int temp = q1.pollFirst();
                cArr1[temp] -= 1;
                if (cArr1[temp] == 0) {
                    arr1[temp] = false;
                    count1--;
                }
            }
            result = Math.max(result, q1.size());
        }
        System.out.println(result);
    }
}
