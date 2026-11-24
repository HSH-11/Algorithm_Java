import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();

        int num = Integer.parseInt(binary, 2);

        num *= 17;

        System.out.print(Integer.toBinaryString(num));
        
    }
}