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

        boolean[] infected = new boolean[N + 1]; 
        int[] remain = new int[N + 1];

        infected[P] = true; // 초기 감염자
        remain[P] = K;

        for (int i = 0; i < T; i++) {
            int p1 = shakes[i][1];
            int p2 = shakes[i][2];

            // 두 사람 모두 감염된 경우
            if (infected[p1] && infected[p2]) {
                remain[p1]--;
                remain[p2]--;
            }            

            // 한쪽이 전염 가능한 상태였고 다른 쪽이 감염되어 있지 않은 상태
            // p1만 감염된 경우
            else if (infected[p1]) {
                if (remain[p1] > 0) {
                    remain[p1]--;
                    infected[p2] = true;
                    remain[p2] = K;
                }
            }
            
            // p2만 감염된 경우
            else if (infected[p2]) {
                if (remain[p2] > 0) {
                    remain[p2]--;
                    infected[p1] = true;
                    remain[p1] = K;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(infected[i] ? 1 : 0);
        }

    }
}