import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_250105_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        int num;
        for(int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());

            if(pq.isEmpty() && num == 0){
                sb.append("0").append("\n");
            }else{
                if(num != 0){
                    pq.offer(num);
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
