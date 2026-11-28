import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a1 = arr[i];
                    int a2 = arr[j];
                    int a3 = arr[k];

                    if (a1 <= a2 && a2 <= a3) ans++;
                }
            }
        }

        System.out.print(ans);
    }
}