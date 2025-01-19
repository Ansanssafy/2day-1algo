import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250115_2023 {
    static int N;
    static StringBuilder sb;
    static int[] primes = {2, 3, 5, 7};
    static int[] primes2 = {1, 3, 7, 9};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int num : primes) {
            dfs(num, 1);
        }
        System.out.println(sb.toString());
    }
    private static void dfs(int num, int length) {
        if (length == N) {
            sb.append(num).append("\n");
            return;
        }
        for (int num2 : primes2) {
            int nextNum = num * 10 + num2;
            if (isPrime(nextNum)) {
                dfs(nextNum, length + 1);
            }
        }
    }

    private static boolean isPrime(int num){
        if (num < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
