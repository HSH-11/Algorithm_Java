import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(F(n));
    }

    public static int F(int n) {
        if (n <= 0) return 0;

        if (n % 2 == 0) return n + F(n-2);
        else return n + F(n-2);
    }
}