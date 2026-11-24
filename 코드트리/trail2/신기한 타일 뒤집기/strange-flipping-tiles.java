import java.util.Scanner;
public class Main {

    static final int OFFSET = 100000;
    static final int SIZE = 200001;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] arr = new char[SIZE];

        int cur = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            int start, end;
            
            if (d == 'L') {
                start = cur - x + 1;
                end = cur;

                for (int j = start; j <= end; j++) {
                    arr[j + OFFSET] = 'W';
                }

                cur = start;

            } else {
                start = cur;
                end = cur + x - 1;

                for (int j = start; j <= end; j++) {
                    arr[j + OFFSET] = 'B';
                }

                cur = end;
            }

        }

        int w = 0, b = 0;

        for (int i = 0; i < SIZE; i++) {
            if (arr[i] == 'W') {
                w++;
            } else if (arr[i] == 'B') {
                b++;
            }
        }

        System.out.print(w + " " + b);
        

    }
}