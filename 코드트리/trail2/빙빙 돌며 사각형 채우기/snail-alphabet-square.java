import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

    // 우측, 아래, 좌측, 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] alphabat = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static int N, M;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder out = new StringBuilder();

        in.nextToken(); N = (int) in.nval;
        in.nextToken(); M = (int) in.nval;
        
        int dir = 0;

        char[][] arr = new char[N][M];

        int x = 0, y = 0;
        arr[x][y] = 'A';

        for (int i = 1; i < N * M; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!inRange(nx, ny) || arr[nx][ny] != '\0')
                dir = (dir + 1) % 4;

            x += dx[dir];
            y += dy[dir];

            arr[x][y] = alphabat[i % 26];
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

