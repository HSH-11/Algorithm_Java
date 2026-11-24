import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (n >= b) {
            int num = n % b;
            sb.append(num);
            n /= b;
        }
        sb.append(n);
        String result = sb.reverse().toString();
        
        System.out.print(result);
    }
}