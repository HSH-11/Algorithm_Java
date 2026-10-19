import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        while (true) {
            if (m % n == 0) break;
            int temp = m % n;
            m = n;
            n = temp;
        }

        System.out.print(n);
    }
}