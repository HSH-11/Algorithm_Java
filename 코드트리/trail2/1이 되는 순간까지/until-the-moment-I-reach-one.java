import java.util.Scanner;
public class Main {

    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
        System.out.print(result);
    }

    public static void f(int n) {
        if (n == 1) return;

        if (n % 2 == 0) {
            result++;
            f(n / 2);
        }
        else {
            result++;
            f (n / 3);
        }
    }
}