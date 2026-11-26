import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] penalizedPerson = new int[n + 1];

        int ans = -1;
        
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            penalizedPerson[num]++;

            if (penalizedPerson[num] >= k) {
                ans = num;
                break;
            }
        }

        System.out.print(ans);
    }
}