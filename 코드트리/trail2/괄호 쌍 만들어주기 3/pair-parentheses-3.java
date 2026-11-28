import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int n = A.length();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            char c = A.charAt((i));
            if (c == ')') continue;

            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) == ')') ans++;
            }
        }

        System.out.print(ans);
        
    }
}