import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        int[] calender = new int[] {0,30,28,31,30,31,30,31,31,30,31,30,31};

        if (m > 12) {System.out.print("No"); return;}

        System.out.print(calender[m] >= d ? "Yes" : "No"); 
    }
}