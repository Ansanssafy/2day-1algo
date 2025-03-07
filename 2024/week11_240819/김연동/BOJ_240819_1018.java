import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240819_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];

        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            arr[i] = line.toCharArray();
        }
        // 여기까지 입력 완료
        int result = Integer.MAX_VALUE;

        // 8x8 체스판 탐색
        for (int x = 0; x <= N - 8; x++) {
            for (int y = 0; y <= M - 8; y++) {
                int count1 = 0;
                int count2 = 0;

                // w시작과 b시작 각각의 비용을 계산
                for (int i = x; i < x + 8; i++) {
                    for (int j = y; j < y + 8; j++) {
                        // w시작
                        if ((i + j) % 2 == 0) { // 짝수 번쨰 W 순서 확인
                            if (arr[i][j] != 'W') {
                                count1++;
                            }
                        } else { // 홀수 번째 B 확인 시작
                            if (arr[i][j] != 'B') {
                                count1++;
                            }
                        }
                        // b시작
                        if ((i + j) % 2 == 0) { // 짝수 번쨰 B 순서 확인
                            if (arr[i][j] != 'B') {
                                count2++;
                            }
                        } else { // 홀수 번째 W 확인 시작
                            if (arr[i][j] != 'W') {
                                count2++;
                            }
                        }
                    }
                }
                int test = Math.min(count1, count2);
                result = Math.min(result, test);
            }
        }

        // 최종적으로 가장 작은 비용을 출력
        System.out.println(result);
    }
}
