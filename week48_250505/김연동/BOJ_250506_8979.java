import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_250506_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Country[] countries = new Country[N];

        int num, gold, silver, bronze;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            gold = Integer.parseInt(st.nextToken());
            silver = Integer.parseInt(st.nextToken());
            bronze = Integer.parseInt(st.nextToken());
            countries[i] = new Country(num, gold, silver, bronze);
        }

        Arrays.sort(countries, (a, b) -> {
            if (b.gold != a.gold){
                return b.gold - a.gold;
            }
            if (b.silver != a.silver){
                return b.silver - a.silver;
            }
            return b.bronze - a.bronze;
        });

        int rank = 1;
        int target = 1;

        for (int i = 0; i < N; i++) {
            if (countries[i].num == K) {
                target = rank;
                break;
            }
            if (i > 0 && (countries[i].gold != countries[i - 1].gold ||
                    countries[i].silver != countries[i - 1].silver ||
                    countries[i].bronze != countries[i - 1].bronze)) {
                rank = i + 1;
            }
        }
        System.out.println(target);
    }
}
class Country {
    int num;
    int gold;
    int silver;
    int bronze;

    Country(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}