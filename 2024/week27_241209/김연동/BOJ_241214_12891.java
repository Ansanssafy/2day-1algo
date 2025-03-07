import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241214_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        char[] cArr = line.toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] chk = new int[4];
        int index = 0;
        while (st.hasMoreTokens()) {
            chk[index++] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int aCnt = 0;
        int cCnt = 0;
        int gCnt = 0;
        int tCnt = 0;

        for(int i = 0; i < P; i++) {
            if(cArr[i] == 'A'){
                aCnt++;
            }else if(cArr[i] == 'C'){
                cCnt++;
            }else if(cArr[i] == 'G'){
                gCnt++;
            }else if(cArr[i] == 'T'){
                tCnt++;
            }
        }

        if(aCnt >= chk[0] && cCnt >= chk[1] && gCnt >= chk[2] && tCnt >= chk[3]){
            result++;
        }

        for(int i = P; i < S; i++) {
            if(cArr[i] == 'A'){
                aCnt++;
            }else if(cArr[i] == 'C'){
                cCnt++;
            }else if(cArr[i] == 'G'){
                gCnt++;
            }else if(cArr[i] == 'T'){
                tCnt++;
            }

            if(cArr[i - P] == 'A'){
                aCnt--;
            }else if(cArr[i - P] == 'C'){
                cCnt--;
            }else if(cArr[i - P] == 'G'){
                gCnt--;
            }else if(cArr[i - P] == 'T'){
                tCnt--;
            }
            if(aCnt >= chk[0] && cCnt >= chk[1] && gCnt >= chk[2] && tCnt >= chk[3]){
                result++;
            }
        }
        System.out.println(result);
    }
}
