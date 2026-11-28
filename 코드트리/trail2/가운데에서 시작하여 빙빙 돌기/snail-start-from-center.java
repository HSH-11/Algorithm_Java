import java.util.Scanner;

public class Main {

    // 좌, 상, 우, 하 
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int x = N - 1;
        int y = N - 1;

        int[][] arr = new int[N][N];

        arr[x][y] = N * N;
        int dir = 0;

        for (int i = N * N - 1; i > 0; i--) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!inRange(nx, ny) || arr[nx][ny] != 0)
                dir = (dir + 1) % 4;

            x += dx[dir];
            y += dy[dir];

            arr[x][y] = i;
        }        

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                out.append(arr[i][j]).append(" ");
            }
            out.append("\n");
        }

        System.out.print(out);

    }

    public static boolean inRange (int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}