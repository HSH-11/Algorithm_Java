import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int dir = 0;
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int x = 0;
        int y = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char d = s.charAt(i);

            if (d == 'L') {
                dir = (dir + 3) % 4;
            }
            else if (d == 'R') {
                dir = (dir + 1) % 4;
            }
            else {
                x += dx[dir];
                y += dy[dir];
            }
                
        }
        
        System.out.print(x + " " + y);
    }
}