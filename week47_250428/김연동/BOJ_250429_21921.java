import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250429_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr= new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int temp = 0;
        int count = 0;
        for(int i = 0; i < X; i++) {
            temp += arr[i];
        }
        result = temp;
        count++;

        int left = 0;
        int right = X;
        while(right < N){
            temp += arr[right++];
            temp -= arr[left++];

            if(temp == result){
                count++;
            }else if (temp > result){
                count = 0;
                count++;
                result = temp;
            }
        }
        sb.append(result).append("\n").append(count);
        if (result == 0) {
            System.out.println("SAD");
        }else{
            System.out.println(sb.toString());
        }
    }
}

