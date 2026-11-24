import java.util.Scanner;

public class Main {

    static int[] days = {
        0, 31, 29, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    static String[] dayOfWeek = {
        "Mon", "Tue", "Wed", "Thu",
        "Fri", "Sat", "Sun"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        
        int diff = getDays(m2, d2) - getDays(m1, d1);

        int startDay = 0;
        int targetDay = 0;

        for (int i = 0; i < 7; i++) {
            if (dayOfWeek[i].equals(A)) {
                targetDay = i;
                break;
            }
        }

        int firstDay = (targetDay - startDay + 7) % 7;

        int answer = 0;

        if (firstDay <= diff) {
            answer = (diff - firstDay) / 7 + 1;
        }

        System.out.print(answer);
    }

    public static int getDays(int m, int d) {
        int total = d;

        for (int i = 1; i < m; i++) {
            total += days[i];
        }

        return total;
    }    
}