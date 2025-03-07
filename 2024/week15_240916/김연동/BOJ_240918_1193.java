import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240918_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X =  Integer.parseInt(br.readLine());
        int sumLine = 0;
        int i = 0;
        while(sumLine < X) {
            sumLine += ++i;
        }
        int temp = sumLine - i;
        // 내려갈 때 (시작은 위, 분모감, 분자증)
        if(i % 2 != 0){
            System.out.println((i - (X - temp - 1))+ "/" + (X - temp));
        }
        //올라갈 때 (아래 시작, 분모증, 분자감)
        else{
            System.out.println((X - temp) + "/" + (i - (X - temp - 1)));
        }
    }
}
