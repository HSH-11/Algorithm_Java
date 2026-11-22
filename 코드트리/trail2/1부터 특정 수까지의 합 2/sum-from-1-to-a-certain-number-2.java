import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(func(n));
    }

    public static int func(int n) {
        if (n == 0) return 0;

        return n + func(n-1);
    }
}