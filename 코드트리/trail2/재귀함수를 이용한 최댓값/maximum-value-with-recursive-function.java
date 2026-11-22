import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    
        System.out.print(findMax(0, arr));
    }

    public static int findMax(int idx, int[] arr) {
        if (idx == arr.length) return arr[idx-1];

        return Math.max(findMax(idx+1, arr), arr[idx]);
    }
}