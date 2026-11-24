import java.util.Scanner;
public class Main {

    static final int SIZE = 201;
    static final int OFFSET = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] arr = new int[SIZE][SIZE];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = x; j < x + 8; j++) {
                for (int k = y; k < y + 8; k++) {
                    if (arr[j + OFFSET][k + OFFSET] != 1) {
                        arr[j + OFFSET][k + OFFSET] = 1;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] == 1) answer++;
            }
        }

        System.out.print(answer);
        
    }
}