import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int dist;
    int index;

    public Point (int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Point point) {
        if (dist != point.dist) {
            return dist - point.dist;
        }
        return index - point.index;
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
            int dist = Math.abs(x) + Math.abs(y);

            points[i] = new Point(dist, i + 1);
        }
        
        Arrays.sort(points);

        for (int i = 0; i < n; i++) {
            System.out.println(points[i].index);
        }
    }
}