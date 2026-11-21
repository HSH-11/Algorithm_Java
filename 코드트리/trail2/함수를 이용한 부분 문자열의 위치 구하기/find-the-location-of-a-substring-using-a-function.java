import java.util.Scanner;
public class Main {

    public static String text, pattern;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        text = sc.next();
        pattern = sc.next();
        
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (isStarted(i)) {
                System.out.print(i);
                return;
            }
        }

        System.out.print("-1");

    }

    public static boolean isStarted (int idx) { {
        int n = pattern.length();

        return text.substring(idx, idx + n).equals(pattern);

    }

    }
}