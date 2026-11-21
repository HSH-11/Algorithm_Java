import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        func (a, b);
    }

    public static void func (int a, int b) {
        if (a > b) {
            a += 25;
            b *= 2;
        } else {
            b += 25;
            a *= 2;
        }

        System.out.print(a + " " + b);
    }
}