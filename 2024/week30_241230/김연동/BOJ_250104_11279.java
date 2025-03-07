import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_250104_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int num;
        for(int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());

            if(num != 0){
                pq.offer(num);
            }else if(num == 0){
                if(pq.isEmpty()){
                    sb.append("0").append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
