import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        recursive1(n);
        System.out.println();
        recursive2(n);
    }

    public static void recursive1(int n) {
        if (n == 0) return;

        recursive1(n-1);
        System.out.print(n + " ");
    }

    public static void recursive2(int n) {
        if (n == 0) return;

        System.out.print(n + " ");
        recursive2(n-1);
    }
}