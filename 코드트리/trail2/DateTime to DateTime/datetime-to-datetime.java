import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if (A == 11) {
            if (B == 11) {
                if (C < 11) {
                    System.out.print("-1");
                    return;
                }
            }
            if (B < 11) {
                System.out.print("-1");
                return;
            }    
        }
        
        int result = (A-11) * 24 * 60 + (B-11) * 60 + (C-11);
        System.out.print(result); 
    }
}