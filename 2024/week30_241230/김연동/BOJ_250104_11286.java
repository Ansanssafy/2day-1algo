import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_250104_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((t1, t2) -> {
            int abs1 = Math.abs(t1);
            int abs2 = Math.abs(t2);

            // 절댓값이 같은 경우 원래 값 기준 정렬
            if (abs1 == abs2) {
                return t2 - t1;
            }
            return abs1 - abs2;
        });

        int num;
        for(int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            if(num != 0){
                pq.offer(num);
            }else{
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
