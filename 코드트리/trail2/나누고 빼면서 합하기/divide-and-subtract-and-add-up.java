import java.util.Scanner;
public class Main {

    static int[] arr;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        System.out.print(func());
    }

    public static int func() {
        int sum = 0;

        while (m >= 1) {
            sum += arr[m];
            m = (m % 2 == 0) ? (m / 2) : (m - 1);
        }

        return sum;

    }
}