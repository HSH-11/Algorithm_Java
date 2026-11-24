import java.util.Scanner;
public class Main {

    static int[] num_of_days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] days = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int diff = getDays(m2, d2) - getDays(m1, d1);

        System.out.print(days[((diff % 7) + 7) % 7]);
    }

    public static int getDays (int m, int d) {

        int day = d;

        for (int i = 0; i < m; i++) {
            day += num_of_days[i];
        }

        return day;
    }
}