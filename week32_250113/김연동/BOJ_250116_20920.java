    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class BOJ_250116_20920 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> map = new HashMap<>();
            String line;
            for(int i=0; i<N; i++) {
                line = br.readLine();
                if(line.length() < M){
                    continue;
                }else{
                    map.put(line, map.getOrDefault(line, 0) + 1);
                }
            }
            ArrayList<String> list = new ArrayList<>(map.keySet());
            list.sort((o1, o2) -> {
                if (!map.get(o1).equals(map.get(o2))) {
                    return map.get(o2) - map.get(o1);
                }
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            });

            for (String result : list) {
                sb.append(result).append("\n");
            }
            System.out.println(sb.toString());
        }
    }
