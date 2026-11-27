import java.util.Scanner;
public class Main {
    static final int MAX_LEN = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] posA = new int[MAX_LEN + 1];
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while (t-- > 0) {
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;
            }
        }

        int timeB = 1;
        int[] posB = new int[MAX_LEN + 1];
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while (t-- > 0) {
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }

        int ans = 0;
        char status = 'N'; // 'N' 공동 선두

        for (int i = 1; i < timeA; i++) {

            if (posA[i] == posB[i]) {
                if (status != 'N') {
                    ans++;
                }

                status = 'N';
            }

            else if (posA[i] > posB[i]) {
                if (status != 'A') {
                    ans++;
                }

                status = 'A';
            }

            else {
                if (status != 'B') {
                    ans++;
                }

                status = 'B';
            }
        }
    
        System.out.print(ans);
    }
}