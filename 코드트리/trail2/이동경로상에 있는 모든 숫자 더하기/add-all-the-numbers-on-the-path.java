import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {

    // 상, 우, 하, 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken(); N = (int) in.nval;
        in.nextToken(); int t = (int) in.nval;
        in.nextToken();
        String commands = in.sval;

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                in.nextToken();
                board[i][j] = (int) in.nval;
            }
        }
        
        int x = N / 2;
        int y = N / 2;
        int dir = 0;
        int answer = board[x][y];

        for (int i = 0; i < t; i++) {
            char c = commands.charAt(i);

            if (c == 'L') {
                dir = (dir + 3) % 4;
            }
            else if (c == 'R') {
                dir = (dir + 1) % 4;
            }
            else {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (inRange(nx, ny)) {
                    x = nx;
                    y = ny;
                    answer += board[x][y];
                }
            }
        }

        System.out.print(answer);
    }

    public static boolean inRange (int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}