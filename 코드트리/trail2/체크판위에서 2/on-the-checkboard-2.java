import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        
        int ans = 0;
        
        // 첫 번째 중간 지점
        for (int x1 = 1; x1 < R - 1; x1++) {
            for (int y1 = 1; y1 < C - 1; y1++) {

                // 시작점과 색깔이 달라야 함
                if (grid[0][0] == grid[x1][y1]) continue;

                // 두 번째 중간 지점
                for (int x2 = x1 + 1; x2 < R - 1; x2++) {
                    for (int y2 = y1 + 1; y2 < C - 1; y2++) {

                        // 첫 번째 중간점과 색깔이 달라야 함
                        if (grid[x1][y1] == grid[x2][y2]) continue;

                        // 도착점과 색깔이 달라야 함
                        if (grid[x2][y2] == grid[R - 1][C - 1]) continue;

                        ans++;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}