//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.StringTokenizer;
//
//public class BOJ_250325_17952 {
//    static int temp, time;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//
//        int result = 0;
//        int homework;
//        Deque<Node> q = new ArrayDeque<Node>();
//        for(int n = 0; n < N; n++){
//            st = new StringTokenizer(br.readLine());
//            homework = Integer.parseInt(st.nextToken());
//            if(homework == 1){
//                if(q.isEmpty()){
//                    temp = Integer.parseInt(st.nextToken());
//                    time = Integer.parseInt(st.nextToken());
//                    time--;
//                    if (time == 0) {
//                        result += temp;
//                    }else{
//                        q.offerLast(new Node(temp, time));
//                    }
//                }else{
//                    temp = Integer.parseInt(st.nextToken());
//                    time = Integer.parseInt(st.nextToken());
//                    time--;
//                    if (time == 0) {
//                        result += temp;
//                    }else{
//                        q.offerLast(new Node(temp, time));
//                    }
//                }
//            }else{
//                if(!q.isEmpty()){
//                    Node now = q.pollLast();
//                    now.time--;
//                    if(now.time == 0){
//                        result += now.temp;
//                    }else{
//                        q.offerLast(new Node(now.temp, now.time));
//                    }
//                }
//            }
//        }
//        System.out.println(result);
//    }
//}
//class Node{
//    int temp;
//    int time;
//    public Node(int temp, int time) {
//        this.temp = temp;
//        this.time = time;
//    }
//}
