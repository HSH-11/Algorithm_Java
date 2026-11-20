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
        
        int length = String.valueOf(n).length();

        String num = Integer.toString(n);

        for (int i = 0; i < length; i++) {
            if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') return true; 
        };

        return false;
    }
}