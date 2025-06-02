import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_250520_22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String word;
        for(int i = 0; i < N; i++){
            word = br.readLine();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(),",");
            while(st.hasMoreTokens()){
                word = st.nextToken();
                map.remove(word);
            }
            sb.append(map.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
