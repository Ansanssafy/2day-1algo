import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_240929_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String result = null;


        for (int i = 1; i < line.length() - 1; i++) {
            for (int j = i + 1; j < line.length(); j++) {
                String chk1 = line.substring(0, i);
                String chk2 = line.substring(i, j);
                String chk3 = line.substring(j);

                StringBuilder sb1 = new StringBuilder(chk1);
                StringBuilder sb2 = new StringBuilder(chk2);
                StringBuilder sb3 = new StringBuilder(chk3);

                String newWord = sb1.reverse().toString() + sb2.reverse().toString() + sb3.reverse().toString();

                if (result == null || newWord.compareTo(result) < 0) {
                    result = newWord;
                }
            }
        }
        System.out.println(result);
    }
}
