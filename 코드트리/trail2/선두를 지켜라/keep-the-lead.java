import java.util.Scanner;

public class Main {

    static final int SIZE = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 거리 저장
        int[] A = new int[SIZE + 1];   
        int timeA = 1;
        int posA = 0;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while (t-- > 0) {
                posA += v;
                A[timeA++] = posA;
            }
        }

        int[] B = new int[SIZE + 1];
        int timeB = 1;
        int posB = 0;
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while (t-- > 0) {
                posB += v;
                B[timeB++] = posB;
            }
        }

        // 추월 계산
        int ans = 0;
        char ahead = 'N';

        for (int i = 1; i < timeA; i++) {
            if (A[i] > B[i]) {
                if (ahead == 'B') {
                    ans++;
                }
                ahead = 'A'; 
            } 
            else if (B[i] > A[i]) {
                if (ahead == 'A') {
                    ans++;
                }
                ahead = 'B';
            }
        }

        System.out.print(ans);
    }
}