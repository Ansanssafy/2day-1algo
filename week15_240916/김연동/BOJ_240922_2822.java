import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_240922_2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList <int[]> arr = new ArrayList<>();
        int num;
        for(int i = 0; i < 8; i++){
            num = Integer.parseInt(br.readLine());
            arr.add(new int[]{i + 1, num});
        }
        arr.sort((a, b) -> b[1] - a[1]);

        ArrayList<Integer> result = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += arr.get(i)[1];
            result.add(arr.get(i)[0]);
        }

        Collections.sort(result);
        for(int index : result){
            sb.append(index).append(" ");
        }
        System.out.println(sum);
        System.out.println(sb.toString());
    }
}
