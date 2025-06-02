import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_250523_20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Player>> rooms = new ArrayList<>();

        int l;
        String n;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = st.nextToken();

            boolean chk = false;

            for (List<Player> room : rooms) {
                if (room.size() >= m){
                    continue;
                }
                int chklevel = room.get(0).level;
                if (Math.abs(chklevel - l) <= 10) {
                    room.add(new Player(l, n));
                    chk = true;
                    break;
                }
            }
            if (!chk) {
                List<Player> newRoom = new ArrayList<>();
                newRoom.add(new Player(l, n));
                rooms.add(newRoom);
            }
        }
        for (List<Player> room : rooms) {
            Collections.sort(room, Comparator.comparing(p1 -> p1.name));
            if (room.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            for (Player player : room) {
                sb.append(player.level + " " + player.name).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
class Player {
    int level;
    String name;

    Player(int level, String name) {
        this.level = level;
        this.name = name;
    }
}
