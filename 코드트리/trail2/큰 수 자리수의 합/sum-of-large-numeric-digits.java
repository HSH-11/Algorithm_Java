import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        System.out.print(f(a*b*c));
    }

    public static int f(int n) {
        if (n < 10) return n;

        return n % 10 + f(n/10);
    }
}