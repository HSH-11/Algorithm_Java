import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        if (judgeDay(y, m, d)) {
            String weather = findWeather(m);
            System.out.print(weather);
        }
        else {
            System.out.print("-1");
        }

    }

    public static boolean isLeafYear(int y) {

        return (y % 400 == 0 || (y % 100 != 0 && y % 4 == 0));
    }

    public static int lastDayNumber(int y, int m) {

        if(m == 2) {
            if (isLeafYear(y)) return 29;
            else return 28;
        }

        if(m == 4 || m == 6 || m == 9 || m == 11)
            return 30;
        
        return 31;
    }
    
    public static boolean judgeDay(int y, int m, int d) {
        if(m <= 12 && d <= lastDayNumber(y, m))
            return true;
        
        return false;
    }

    public static String findWeather(int m) {
        if (m >= 3 && m <= 5) {
            return "Spring";
        }
        else if (m >= 6 && m <= 8) {
            return "Summer";
        }
        else if (m >= 9 && m <= 11) {
            return "Fall";
        }
        else {
            return "Winter";
        }
    }
}