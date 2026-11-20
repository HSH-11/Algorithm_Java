import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int result = 0;

        for (int i = A; i <= B; i++) {
            if (isMagicNumber(i)) result++; 
        }

        System.out.print(result);
    }

    public static boolean isMagicNumber(int n) {
        
        if (n % 3 == 0) return true;

        String num = String.valueOf(n);

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            if (c == '3' || c == '6' || c == '9') return true; 
        };

        return false;
    }
}