import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_250501_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String password;

        while (!(password = br.readLine()).equals("end")) {
            boolean chk1 = false; // 모음 체크
            boolean chk2 = true; // 연속 체크
            int cCount = 0; // Consonant 자음
            int vCount = 0; // vowels 모음

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                boolean isVowel = "aeiou".indexOf(c) != -1;

                if (isVowel) {
                    if(!chk1) {
                        chk1 = true;
                    }
                    vCount++;
                    cCount = 0;
                } else {
                    cCount++;
                    vCount = 0;
                }

                if (vCount == 3 || cCount == 3) {
                    chk2 = false;
                    break;
                }

                if (i > 0 && c == password.charAt(i - 1)) {
                    if (!(c == 'e' || c == 'o')) {
                        chk2 = false;
                        break;
                    }
                }
            }

            sb.append("<").append(password).append("> ");
            if (chk1 && chk2) {
                sb.append("is acceptable.\n");
            } else {
                sb.append("is not acceptable.\n");
            }
        }
        System.out.print(sb.toString());
    }
}