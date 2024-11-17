import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_241117_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String word = br.readLine();

        int count = 0;
        int index = 0;

        while (index <= line.length() - word.length()) {
            if (line.substring(index, index + word.length()).equals(word)) {
                count++;
                index += word.length();
            } else {
                index++;
            }
        }
        System.out.println(count);
    }
}