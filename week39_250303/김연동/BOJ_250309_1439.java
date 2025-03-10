import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250309_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        char[] arr = line.toCharArray();

        int count0 = 0;
        int count1 = 0;

        if(arr[0] == '0'){
            count1 += 1;
        }else{
            count0 += 1;
        }

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] != arr[i + 1]){
                if(arr[i + 1] == '0'){
                    count1 += 1;
                }else{
                    count0 += 1;
                }
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}