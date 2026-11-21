import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        swap(n, m); 
    }

    public static void swap (int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.print(a + " " + b);
    }
}