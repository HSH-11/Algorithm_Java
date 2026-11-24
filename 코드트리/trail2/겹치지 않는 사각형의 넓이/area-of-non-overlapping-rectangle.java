import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 직사각형 A
        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();

        // 직사각형 B
        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();

        // 직사각형 M
        int mx1 = sc.nextInt();
        int my1 = sc.nextInt();
        int mx2 = sc.nextInt();
        int my2 = sc.nextInt();
        
        // A와 B의 전체 넓이 
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        // A와 M 겹치는 넓이
        int overlapA = getOverlap(
            ax1, ay1, ax2, ay2,
            mx1, my1, mx2, my2
        );

        int overlapB = getOverlap(
            bx1, by1, bx2, by2,
            mx1, my1, mx2, my2
        );

        int answer = areaA + areaB - overlapA - overlapB;

        System.out.print(answer);
    }

    // 두 직사각형이 겹치는 넓이 계산
    public static int getOverlap(
        int x1, int y1, int x2, int y2,
        int mx1, int my1, int mx2, int my2
    ) {
        int left = Math.max(x1, mx1); // 두 사각형의 x 최소값 중 큰 값 
        int right = Math.min(x2, mx2);

        int bottom = Math.max(y1, my1);
        int top = Math.min(y2, my2);

        // 겹치는 영역이 없는 경우
        if (left >= right || bottom >= top) {
            return 0;
        }

        return (right - left) * (top - bottom);
    }
}