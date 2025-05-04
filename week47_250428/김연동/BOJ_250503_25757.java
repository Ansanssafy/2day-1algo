import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_250503_25757 {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        if(game == 'Y'){
            System.out.println(Yut(N));
        }else if(game == 'F'){
            System.out.println(picture(N));
        }else{
            System.out.println(card(N));
        }
    }
    public static int Yut(int N) throws IOException{
        int count = 1;
        int result = 0;

        HashMap<String, Integer> map = new HashMap<>();
        String name;
        for(int i = 0; i < N; i++){
            name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
            if(map.get(name) == 1){
                count++;
                if(count == 2){
                    result++;
                    count = 1;
                }
            }
        }
        return result;
    }
    public static int picture(int N) throws IOException{
        int count = 1;
        int result = 0;

        HashMap<String, Integer> map = new HashMap<>();
        String name;
        for(int i = 0; i < N; i++){
            name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
            if(map.get(name) == 1){
                count++;
                if(count == 3){
                    result++;
                    count = 1;
                }
            }
        }

        return result;
    }
    public static int card(int N) throws IOException{
        int count = 1;
        int result = 0;

        HashMap<String, Integer> map = new HashMap<>();
        String name;
        for(int i = 0; i < N; i++){
            name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
            if(map.get(name) == 1){
                count++;
                if(count == 4){
                    result++;
                    count = 1;
                }
            }
        }
        return result;
    }
}
