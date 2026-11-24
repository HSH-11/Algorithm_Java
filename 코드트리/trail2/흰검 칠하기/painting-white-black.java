import java.util.Scanner;

public class Main {
    static final int OFFSET = 100000;
    static final int SIZE = 200005;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] white = new int[SIZE];
        int[] black = new int[SIZE];
        char[] color = new char[SIZE];

        int cur = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            int start, end;
            char paint;

            if (dir == 'L') {
                start = cur - x + 1;
                end = cur;
                paint = 'W';
                cur = start;
            } else {
                start = cur;
                end = cur + x - 1;
                paint = 'B';
                cur = end;
            }

            for (int j = start; j <= end; j++) {
                int idx = j + OFFSET;

                if (paint == 'W') {
                    white[idx]++;
                } else {
                    black[idx]++;
                }

                if (color[idx] != 'G') {
                    if (white[idx] >= 2 && black[idx] >= 2) {
                        color[idx] = 'G';
                    } else {
                        color[idx] = paint;
                    }
                }
            }
        }

        int w = 0, b = 0, g = 0;

        for (int i = 0; i < SIZE; i++) {
            if (color[i] == 'W') w++;
            else if (color[i] == 'B') b++;
            else if (color[i] == 'G') g++;
        }

        System.out.print(w + " " + b + " " + g);

        
    }
}