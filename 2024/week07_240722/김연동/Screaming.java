import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Screaming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println("1이랑 0은 없습니다");

        System.out.print("원하는 길이를 입력하시오 : ");

        int N = Integer.parseInt(br.readLine());

        if(N == 1 || N == 0){
            System.out.println("없다고 했다");
        }
        else if(N == 2){
            System.out.println("으악");
        }else{
            for(int i = 1; i < N; i++) {
                sb = new StringBuilder();
                sb.append("으");
                for(int j = 1; j < i; j++){
                    sb.append("아");
                }
                sb.append("악");
                System.out.println(sb.toString());
            }
        }
    }
}
