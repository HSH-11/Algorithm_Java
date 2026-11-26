import java.util.Scanner;

public class Main {
    static final int MAX = 2000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int timeA = 1;
        int[] posA = new int[MAX + 1];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while (t-- > 0) {
                if (d == 'L') {
                    posA[timeA] = posA[timeA - 1] - 1;
                }
                else {
                    posA[timeA] = posA[timeA - 1] + 1;
                }

                timeA++;

            }
        }

        int timeB = 1;
        int[] posB = new int[MAX + 1];
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while (t-- > 0) {
                if (d == 'L') {
                    posB[timeB] = posB[timeB - 1] - 1;
                }
                else {
                    posB[timeB] = posB[timeB - 1] + 1;
                }

                timeB++;
            }
        }

        if (timeA > timeB) {
            for (int i = timeB; i < timeA; i++) {
                posB[i] = posB[timeB - 1];
            }
        } else {
            for (int i = timeA; i < timeB; i++) {
                posA[i] = posA[timeA - 1];
            }
        }

        int time = Math.max(timeA, timeB);
        int ans = 0;
        for (int i = 1; i < time; i++) {
            // System.out.println(i + "초 " + "A : " + posA[i] + " B : " + posB[i]);
            if ((posA[i - 1] != posB[i - 1]) && (posA[i] == posB[i])) {
                ans++;
            }

        }

        System.out.println(ans);
    }
}
