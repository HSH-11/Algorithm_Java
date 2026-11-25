import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        
        int len = 0;
        int answer = 0;

        for (int i = 0; i < n; i++){
            int num = sc.nextInt();

            if (num > t) len++;
            else len = 0;

            answer = Math.max(answer, len);
        }

        System.out.print(answer);

    }
}