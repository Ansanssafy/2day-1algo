import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250505_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        String line;
        char[][] cookie = new char[N][N];
        for(int i = 0; i < N; i++) {
            line = br.readLine();
            cookie[i] = line.toCharArray();
        }
        int rHeart = 0;
        int cHeart = 0;
        start : for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cookie[i][j] == '*') {
                    rHeart = i + 1;
                    cHeart = j;
                    sb.append(rHeart + 1).append(" ").append(cHeart + 1).append("\n");
                    break start;
                }
            }
        }
        int lArm = 0;
        int rArm = 0;
        int disk = 0;
        int lLeg = 0;
        int rLeg = 0;
        for(int j = cHeart - 1; j >= 0; j--){
            if(cookie[rHeart][j] != '*') {
                break;
            }
            lArm++;
        }
        for(int j = cHeart + 1; j < N; j++){
            if(cookie[rHeart][j] != '*') {
                break;
            }
            rArm++;
        }
        int legStart = 0;
        for(int i = rHeart + 1; i < N; i++){
            if(cookie[i][cHeart] != '*') {
                legStart = i;
                break;
            }
            disk++;
        }
        for(int i = legStart; i < N; i++){
            if(cookie[i][cHeart - 1] != '*') {
                break;
            }
            lLeg++;
        }
        for(int i = legStart; i < N; i++){
            if(cookie[i][cHeart + 1] != '*') {
                break;
            }
            rLeg++;
        }
        sb.append(lArm).append(" ").append(rArm).append(" ").append(disk).append(" ").append(lLeg).append(" ").append(rLeg).append(" ");
        System.out.println(sb.toString());
    }
}
