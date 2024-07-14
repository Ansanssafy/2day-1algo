import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240714_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[31];
        int n;

        for(int i = 0; i < 28; i++){
            n = Integer.parseInt(br.readLine());
            arr[n] = true;
        }
        for(int i = 1; i <= 30; i++){
            if(arr[i] == true){
                continue;
            }else{
                System.out.println(i);
            }
        }
    }
}
