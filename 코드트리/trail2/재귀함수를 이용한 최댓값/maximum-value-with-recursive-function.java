import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        System.out.print(findMax(0, arr, max));
    }

    public static int findMax(int idx, int[] arr, int max) {
        if (idx == arr.length) return max;

        if (arr[idx] >= max) return findMax(idx+1, arr, arr[idx]);
        else return findMax(idx+1, arr, max);
    }
}