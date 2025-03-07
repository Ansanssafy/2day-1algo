import java.util.*;
import java.io.*;

public class BOJ_241027_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (true) {
            line = br.readLine();
            if (line.equals(".")) {
                break;
            }

            Deque<String> q = new ArrayDeque<>();
            String[] wdrds = line.split("");

            for (String word : wdrds) {
                switch (word) {
                    case ("("):
                    case ("["):
                        q.offerLast(word);
                        break;
                    case (")"):
                        if (!q.isEmpty() && q.peekLast().equals("("))
                            q.pollLast();
                        else q.offerLast(")");
                        break;
                    case ("]"):
                        if (!q.isEmpty() && q.peekLast().equals("[")) {
                            q.pollLast();
                        }
                        else{
                            q.offerLast("]");
                        }
                        break;
                    }
                }
            if (q.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}