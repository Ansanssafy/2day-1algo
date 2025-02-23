//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.StringTokenizer;
//
//public class BOJ_250223_16953 {
//    static long A, B;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        A = Long.parseLong(st.nextToken());
//        B = Long.parseLong(st.nextToken());
//
//        System.out.println(bfs(A));
//    }
//
//    static int bfs(long a) {
//        Deque<Node> q = new ArrayDeque<>();
//        q.offerLast(new Node(a, 1));
//
//        while (!q.isEmpty()) {
//            Node now = q.pollFirst();
//            if(now.num == B){
//                return now.count;
//            }
//            long[] next = {now.num * 10 + 1, now.num * 2};
//            for(long i : next) {
//                if (i <= B) {
//                    q.offerLast(new Node(i, now.count + 1));
//                }
//            }
//        }
//        return -1;
//    }
//}
//
//class Node {
//    long num;
//    int count;
//
//    public Node(long num, int count) {
//        this.num = num;
//        this.count = count;
//    }
//}
