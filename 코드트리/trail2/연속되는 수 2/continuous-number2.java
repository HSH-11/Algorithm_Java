import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int prev = sc.nextInt();
        int answer = 1;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            int num = sc.nextInt();

            if (num == prev) {
                cnt++;
            } else {
                cnt = 1;
            }

            answer = Math.max(answer, cnt);
            prev = num;        
        }

        System.out.print(answer);
        
    }
}