import java.util.Scanner;

public class Main {
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        arr = new int[n + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x][y] = 1;
            
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && arr[nx][ny] == 1)
                    cnt++;
            }

            System.out.println((cnt == 3) ? "1" : "0");
        
        }

    }

    public static boolean inRange (int r, int c) {
        return (1 <= r && r <= n && 1 <= c && c <= n);
    }
}