import java.util.Scanner;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print(getLcm(1,arr[0]));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd (b, a % b);
    }

    public static int lcm (int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static int getLcm(int idx, int result) {
        if (idx == arr.length) return result;

        result = lcm(result, arr[idx]);

        return getLcm(idx + 1, result);
    }
}