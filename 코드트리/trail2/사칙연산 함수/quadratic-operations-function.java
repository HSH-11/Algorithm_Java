import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();
        
        calculator(a, o, c);
    }

    public static void calculator (int a , char o, int c) {
        int result = 0;

        if (o == '+') {
            result = a + c;
            System.out.print(a + " " + o + " " + c + " = " + result);
        }
        else if (o == '-') {
            result = a - c;
            System.out.print(a + " " + o + " " + c + " = " + result);
        }
        else if (o == '*') {
            result = a * c;
            System.out.print(a + " " + o + " " + c + " = " + result);
        }
        else if (o == '/') {
            result = a / c;
            System.out.print(a + " " + o + " " + c + " = " + result);
        }
        else {
            System.out.print("False");
        }
    } 

}