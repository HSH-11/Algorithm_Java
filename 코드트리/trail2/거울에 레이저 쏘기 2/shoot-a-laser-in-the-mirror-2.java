import java.util.Scanner;

public class Main {

    // 아래, 좌측, 위, 우측
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N;


    // '/' : {아래->좌, 좌->아래, 위->우, 우->위} dir ^ 1
    // '\' : {아래->우, 좌->위, 위->좌, 우->아래} 3 - dir
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt(); // 레이저 쏘는 위치
        
        // 처음에 진입하는 칸 좌표 및 구하기
        // dir 0:위쪽, 1:오른쪽 (<-), 2:아래쪽, 3:왼쪽 (->) 
        int dir = (startNum - 1) / N; 
        int pos = (startNum - 1) % N;

        int x = 0;
        int y = 0;

        if (dir == 0) {
            x = 0;
            y = pos;
        }
        else if (dir == 1) {
            x = pos;
            y = N - 1;
        }
        else if (dir == 2) {
            x = N - 1;
            y = N - 1 - pos;
        }
        else {
            x = N - 1 - pos;
            y = 0;
        } 

        int ans = 0;
        // 거울에 따른 방향 전환
        while (true) {

            if (!inRange(x, y)) break;

            if (grid[x][y] == '/') {
                dir = dir ^ 1;
            }
            else {
                dir = 3 - dir;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            ans++;
            x = nx;
            y = ny;
        }
        
        System.out.print(ans);

    }

    public static boolean inRange (int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}
