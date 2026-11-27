import java.util.Scanner;
public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        int[][] arr = new int[n][m];
        int x = 0, y = 0;
        int dir = 0;

        arr[x][y] = 1;
        for (int i = 2; i <= n * m; i++) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!inRange(nx, ny) || arr[nx][ny] != 0)
                dir = (dir + 1) % 4; 

            x += dx[dir];
            y += dy[dir];

            arr[x][y] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean inRange (int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }
}