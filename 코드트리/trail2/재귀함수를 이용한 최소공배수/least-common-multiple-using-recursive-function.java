import java.util.Scanner;

public class Main {

    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        result = arr[0];

        for (int i = 1; i < n; i++) {
            result = lcm(result, arr[i]);
        }    

        System.out.print(result);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd (b, a % b);
    }

    public static int lcm (int a, int b) {
        return a / gcd(a, b) * b;
    }
}