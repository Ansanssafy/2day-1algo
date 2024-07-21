import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_240721_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Node> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            q.offerLast(new Node(i,Integer.parseInt(st.nextToken())));
        }
        while(!q.isEmpty()) {
            Node now = q.pollFirst();
            sb.append(now.index + 1).append(" ");
            if(q.isEmpty()){
                break;
            }
            int move = now.num;
            if(move > 0){
                for(int i = 0; i < move - 1; i++) {
                    q.offerLast(q.pollFirst());
                }
            }else{
                for(int i = 0; i < Math.abs(move); i++) {
                    q.offerFirst(q.pollLast());
                }
            }
        }
        System.out.println(sb.toString());
    }
}
class Node{
    int index;
    int num;
    Node(int index, int num){
        this.index = index;
        this.num = num;
    }
}