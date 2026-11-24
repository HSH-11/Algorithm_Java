import java.util.Scanner;

public class Main {

    static final int SIZE = 2001;
    static final int OFFSET = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt();
        int rect1_y1 = sc.nextInt();
        int rect1_x2 = sc.nextInt();
        int rect1_y2 = sc.nextInt();
        int rect2_x1 = sc.nextInt();
        int rect2_y1 = sc.nextInt();
        int rect2_x2 = sc.nextInt();
        int rect2_y2 = sc.nextInt();
        
        int[][] arr = new int[SIZE][SIZE];

        // 첫 번째 직사각형 배치
        for (int x = rect1_x1; x < rect1_x2; x++) {
            for (int y = rect1_y1; y < rect1_y2; y++) {
                arr[x + OFFSET][y + OFFSET] = 1;
            }
        }

        // 두 번째 직사각형 배치
        for (int x = rect2_x1; x < rect2_x2; x++) {
            for (int y = rect2_y1; y < rect2_y2; y++) {
                arr[x + OFFSET][y + OFFSET] = 2;
            }
        }

        int answer = 0;

        int minX = SIZE;
        int maxX = -1;
        int minY = SIZE;
        int maxY = -1;

        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (arr[x][y] == 1) {
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);

                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        

        if (maxX != -1) {
            answer = (maxX - minX + 1) * (maxY - minY + 1);
        }

        System.out.print(answer);
    }
}