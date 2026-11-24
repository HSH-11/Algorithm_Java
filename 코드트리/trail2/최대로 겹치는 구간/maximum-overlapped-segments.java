import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int OFFSET = 100;
        int[] arr = new int[201];
        
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            arr[x1 + OFFSET]++;
            arr[x2 + OFFSET]--;
        }
        
        int count = 0;
        int answer = 0;

        for (int i = 0; i < 201; i++) {
            count += arr[i];
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}