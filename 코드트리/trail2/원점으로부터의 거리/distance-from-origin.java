import java.util.Arrays;
import java.util.Scanner;

class Point {
    int x, y, num;

    public Point (int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            points[i] = new Point(x, y, i + 1);
        }
        
        Arrays.sort(points, (a,b) -> (Math.abs(a.x) + Math.abs(a.y)) - (Math.abs(b.x) + Math.abs(b.y)));

        for (int i = 0; i < n; i++) {
            System.out.println(points[i].num);
        }
    }
}