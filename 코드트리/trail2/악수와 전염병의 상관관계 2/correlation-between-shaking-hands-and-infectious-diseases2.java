import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 개발자 수
        int K = sc.nextInt(); // 감염자가 옮길 수 있는 악수 수
        int P = sc.nextInt(); // 초기 감염자
        int T = sc.nextInt(); // 악수 기록
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt(); // t초 시점
            shakes[i][1] = sc.nextInt();
            shakes[i][2] = sc.nextInt();
        }
        
        // 시각이 이른 것부터 처리
        Arrays.sort(shakes, (a, b) -> Integer.compare(a[0], b[0]));

        // 감염 여부[0], 전염병 옮길 수 있는 잔여 수[1]
        int[][] isInfected = new int[N + 1][2]; 
        isInfected[P][0] = 1; // 초기 감염자
        isInfected[P][1] = K;

        for (int i = 0; i < T; i++) {
            int p1 = shakes[i][1];
            int p2 = shakes[i][2];

            // 양쪽 모두 전염 가능한 상태이면 남은 전염 횟수 각각 하나씩 소진
            if (isInfected[p1][0] == 1 && isInfected[p2][0] == 1) {
                isInfected[p1][1]--;
                isInfected[p2][1]--;
                continue;
            }            

            // 한쪽이 전염 가능한 상태였고 다른 쪽이 감염되어 있지 않은 상태
            // 단, 전염 가능 횟수가 남아 있어야 함
            if (isInfected[p1][0] == 1 && isInfected[p2][0] == 0) {
                if (isInfected[p1][1] <= 0)
                    continue;
                
                isInfected[p1][1]--;
                isInfected[p2][0] = 1;
                isInfected[p2][1] = K;
            } else if (isInfected[p1][0] == 0 && isInfected[p2][0] == 1) {
                if (isInfected[p2][1] <= 0)
                    continue;

                isInfected[p2][1]--;
                isInfected[p1][0] = 1;
                isInfected[p1][1] = K;
            }

            // 둘 다 감염자가 아님
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(isInfected[i][0]);
        }

    }
}