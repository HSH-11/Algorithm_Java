import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        
        int[] dy = new int[] {0, -1, 0, 1};
        int[] dx = new int[] {1, 0, -1, 0};

        int dir = 3; // 북쪽

        int n = commands.length();

        int x = 0, y = 0;
        int time = 0;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            char c = commands.charAt(i);

            time++;

            if (c == 'R') {
                dir = (dir + 1) % 4;
            }
            else if (c == 'L') {
                dir = (dir + 3) % 4;
            }
            else {
                x += dx[dir];
                y += dy[dir];
            }

            if (x == 0 && y == 0) {
                ans = time;
                break;
            }
        } 

        System.out.print(ans);
    }
}