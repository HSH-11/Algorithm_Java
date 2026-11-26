import java.util.Scanner;

public class Main {
    public static char[] d = new char[1001];
    public static int[] t = new int[1001];
    public static char[] d2 = new char[1001];
    public static int[] t2 = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int totalTime = 0;

        for (int i = 1; i <= n; i++) {
            d[i] = sc.next().charAt(0);
            t[i] = sc.nextInt();
            // A와 B가 총 이동한 시간은 항상 동일
            totalTime += t[i];
        }

        for (int i = 1; i <= m; i++) {
            d2[i] = sc.next().charAt(0);
            t2[i] = sc.nextInt();           
        }

        int[] posA = new int[totalTime + 1];
        int[] posB = new int[totalTime + 1];

        int pos = 0;
        int time = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < t[i]; j++) {
                if (d[i] == 'R') {
                    pos++;
                } else {
                    pos--;
                }

                posA[++time] = pos;
            }
        }

        pos = 0;
        time = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < t2[i]; j++) {
                if (d2[i] == 'R') {
                    pos++;
                } else {
                    pos--;
                }

                posB[++time] = pos;
            }
        }

        for (int i = 1; i <= totalTime; i++) {
            if (posA[i] == posB[i]) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);
   
    }


}