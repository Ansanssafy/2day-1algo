import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241103_1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int year1 = Integer.parseInt(st.nextToken());
        int month1 = Integer.parseInt(st.nextToken());
        int day1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int year2 = Integer.parseInt(st.nextToken());
        int month2 = Integer.parseInt(st.nextToken());
        int day2 = Integer.parseInt(st.nextToken());

        int days1 = 0, days2 = 0;

        for (int i = 1; i < year1; i++) {
            days1 += (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) ? 366 : 365;
        }
        int[] monthDays1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year1 % 4 == 0 && (year1 % 100 != 0 || year1 % 400 == 0)) {
            monthDays1[1] = 29;
        }
        for (int i = 0; i < month1 - 1; i++) {
            days1 += monthDays1[i];
        }
        days1 += day1;

        for (int i = 1; i < year2; i++) {
            days2 += (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) ? 366 : 365;
        }
        int[] monthDays2 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year2 % 4 == 0 && (year2 % 100 != 0 || year2 % 400 == 0)) {
            monthDays2[1] = 29;
        }
        for (int i = 0; i < month2 - 1; i++) {
            days2 += monthDays2[i];
        }
        days2 += day2;

        if ((year2 - year1 > 1000) ||
                (year2 - year1 == 1000 && month2 - month1 > 0) ||
                (year2 - year1 == 1000 && month2 - month1 == 0 && day2 - day1 >= 0)) {
            System.out.println("gg");
        } else {
            System.out.println("D-" + (days2 - days1));
        }
    }
}
