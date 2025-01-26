import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_250126_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        HashMap<String, Boolean> map = new HashMap<>();

        String log;
        for(int i = 0; i < N; i++) {
            log = br.readLine();
            if(log.equals("ENTER")) {
                map.clear();
            }else{
                if(!map.containsKey(log)) {
                    map.put(log, true);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
