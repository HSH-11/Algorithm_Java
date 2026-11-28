import java.util.Scanner;
public class Main {

    static final int INT_MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int minVal = INT_MAX;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(a[j] * Math.abs(i - j));
            }
            
            minVal = Math.min(sum, minVal);
        }

        System.out.print(minVal);
    }
}