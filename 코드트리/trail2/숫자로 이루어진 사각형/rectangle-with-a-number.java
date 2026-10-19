import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[index % 9] + " ");
                index++;
            }
            System.out.println(" ");
        }
    }
}