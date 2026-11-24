import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        
        int decimal = Integer.parseInt(N, A);

        String answer = Integer.toString(decimal, B);

        System.out.print(answer);

    }
}