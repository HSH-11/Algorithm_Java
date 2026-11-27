import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

    // 아래, 우측, 위, 좌측
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder out = new StringBuilder();

        in.nextToken(); N = (int) in.nval;
        in.nextToken(); M = (int) in.nval;
        
        int dir = 0;

        int[][] arr = new int[N][M];
        
        int x = 0, y = 0;
        arr[x][y] = 1;


        for (int i = 2; i <= N * M; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!inRange(nx, ny) || arr[nx][ny] != 0)
                dir = (dir + 1) % 4;
            
            x += dx[dir];
            y += dy[dir];

            arr[x][y] = i;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.append(arr[i][j]).append(" ");
            }
            out.append("\n");
        }

        System.out.print(out);
    }

    public static boolean inRange (int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}