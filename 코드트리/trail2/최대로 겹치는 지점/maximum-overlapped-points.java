import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[102];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            arr[x1]++;
            arr[x2 + 1]--;
        }
        
        // 누적합으로 겹치는 선분 수 계산
        int count = 0;
        int max = 0;

        for (int i = 1; i <= 101; i++) {
            count += arr[i];
            max = Math.max(max, count);
        }

        System.out.print(max);
    }
}