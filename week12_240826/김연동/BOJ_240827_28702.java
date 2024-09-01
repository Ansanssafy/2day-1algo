import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240827_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean[] chk = new boolean[3];
        String[] arr = new String[3];
        int temp = 0;

        for(int i = 0; i < 3; i++){
            line = br.readLine();
            arr[i] = line;
            if(line.equals("Fizz") || line.equals("Buzz") || line.equals("FizzBuzz")) {
                chk[i] = true;
            }
        }
        for(int i = 0; i < 3; i++){
            if(!chk[i]) {
                temp = Integer.parseInt(arr[i]);
                temp += (3 - i);
                break;
            }
        }
        if(temp % 3 == 0 && temp % 5 == 0){
            System.out.println("FizzBuzz");
        } else if (temp % 3 == 0 && !(temp % 5 == 0)) {
            System.out.println("Fizz");
        }else if (temp % 5 == 0 && !(temp % 3 == 0)) {
            System.out.println("Buzz");
        }else{
            System.out.println(temp);
        }
    }
}
