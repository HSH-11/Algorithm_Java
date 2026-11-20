import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(isMagicNumber(n));
    }

    public static String isMagicNumber(int n) {
        
        return ((n / 10 + n % 10) % 5 == 0 && n % 2 == 0) ? "Yes" : "No";
    }
}