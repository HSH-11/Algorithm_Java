import java.util.Scanner;
public class Main {
    public static final int OFFSET = 1000;
    public static final int MAX_R = 2000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[MAX_R + 1];

        int cur = 0;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            
            int next;

            if (dir == 'R') {
                next = cur + x;
            } else {
                next = cur - x;
            }

            // 이동 방향과 관계없이 항상 작은 좌표를 L
            int L = Math.min(cur, next);
            int R = Math.max(cur, next);

            arr[L + OFFSET]++;
            arr[R + OFFSET]--;

            cur = next;
        }

        // 누적합으로 방문 횟수 계산
        int count = 0;
        int answer = 0;

        for (int i = 0; i < MAX_R; i++) {
            count += arr[i];

            if (count >= 2) {
                answer++;
            }
        }

        System.out.println(answer);       
    }
}