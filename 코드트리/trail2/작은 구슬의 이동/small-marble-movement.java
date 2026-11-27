import java.util.Scanner;

public class Main {

    static int[] dx = new int[] {0, 1, -1, 0};
    static int[] dy = new int[] {1, 0, 0, -1};
    static int N;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        String D = sc.next();

        int[][] arr = new int[N + 1][N + 1];
        int x = R;
        int y = C;

        int dir = getDir(D.charAt(0));

        for (int i = 0; i < T; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 충돌 확인
            if (!isRange(nx, ny)) {
                dir = 3 - dir;
            }
            
            else {
                x += dx[dir];
                y += dy[dir]; 
            }
            

        }

        System.out.print(x + " " + y);
    }

    static int getDir(char a) {
        if (a == 'R')
            return 0;
        else if (a == 'D')
            return 1;
        else if (a == 'U')
            return 2;
        else 
            return 3;
    }

    static boolean isRange (int r, int c) {
        return (1 <= r && r <= N && 1 <= c && c <= N);
    }
}