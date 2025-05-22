import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_250518_3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 수
            int k = Integer.parseInt(st.nextToken()); // 총 문제 수
            int tId = Integer.parseInt(st.nextToken()); // 내 팀
            int m = Integer.parseInt(st.nextToken()); // 로그 수

            int[] count = new int[n + 1];
            int[][] grade = new int[n + 1][k + 2];
            int[] last = new int[n + 1];

            for(int log = 1; log <= m; log++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()); // 제출 팀
                int pNum = Integer.parseInt(st.nextToken()); // 문제 번호
                int s = Integer.parseInt(st.nextToken()); // 점수

                count[id]++;
                last[id] = log;
                if(grade[id][pNum] < s) {
                    grade[id][k + 1] += (s - grade[id][pNum]);
                    grade[id][pNum] = s;
                }
            }

            int myGrade = grade[tId][k + 1];
            int myCount = count[tId];
            int myLast = last[tId];
            int rank = 1;

            for(int i = 1; i <= n; i++) {
                if(i == tId){
                    continue;
                }

                if(grade[i][k + 1] > myGrade) {
                    rank++;
                } else if(grade[i][k + 1] == myGrade) {
                    if(count[i] < myCount) {
                        rank++;
                    } else if(count[i] == myCount) {
                        if(last[i] < myLast) {
                            rank++;
                        }
                    }
                }
            }
            sb.append(rank).append("\n");
        }
        System.out.println(sb.toString());
    }
}
