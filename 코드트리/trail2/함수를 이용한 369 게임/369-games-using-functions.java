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

        while (n > 0) {
            int digit = n % 10;

            if (digit == 3 || digit == 6 || digit == 9) {
                return true;
            }

            n /= 10;
        }

        return false;
    }
}