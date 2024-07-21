import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240721_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        double score;
        String grade;
        double tmp = 0;
        double total = 0;

        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            line = st.nextToken();

            score = Double.parseDouble(st.nextToken());
            grade = st.nextToken();

            switch(grade){
                case "A+":
                    tmp += (score * 4.5);
                    break;
                case "A0":
                    tmp += (score * 4.0);
                    break;
                case "B+":
                    tmp += (score * 3.5);
                    break;
                case "B0":
                    tmp += (score * 3.0);
                    break;
                case "C+":
                    tmp += (score * 2.5);
                    break;
                case "C0":
                    tmp += (score * 2.0);
                    break;
                case "D+":
                    tmp += (score * 1.5);
                    break;
                case "D0":
                    tmp += (score * 1.0);
                    break;
                case "F":
                    tmp += (score * 0);
                    break;
                case "P":
                    total -= score;
                    break;

            }
            total += score;
        }
        System.out.printf("%.6f", (tmp / total));
    }
}
