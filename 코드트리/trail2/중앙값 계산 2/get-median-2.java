import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i += 2) {
            System.out.print(findMedian(i)+ " ");
        }
    }

    public static int findMedian(int n) {
        int mid = n / 2;
        Arrays.sort(arr,0,n+1);
        return arr[mid];
    }
}