import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
    
        func(a, b);
    }

    public static void func (int a, int b) {
        
        if (a > b) {
            a *= 2;
            b += 10;
        }
        else {
            a += 10;
            b *= 2;
        }

        System.out.print(a + " " + b);
    }
}