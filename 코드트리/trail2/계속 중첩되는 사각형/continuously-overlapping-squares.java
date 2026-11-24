import java.util.Scanner;
public class Main {
    
    static final int OFFSET = 100;
    static final int SIZE = 201;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] arr = new char[SIZE][SIZE];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            char color = (i % 2 == 0) ? 'R' : 'B';

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    arr[x + OFFSET][y + OFFSET] = color;
                }
            }
        }

        int answer = 0;

        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (arr[x][y] == 'B') answer++;
            }
        }

        System.out.print(answer);
    }
}
