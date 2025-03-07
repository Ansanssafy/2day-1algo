import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_240915_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2  = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }
        int key;
        String line;
        for(int i = 1; i <= M; i++) {
            line = br.readLine();
            if(chk(line)){
                key = Integer.parseInt(line);
                sb.append(map1.get(key)).append("\n");
            }else{
                sb.append(map2.get(line)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean chk(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (!Character.isDigit(line.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
