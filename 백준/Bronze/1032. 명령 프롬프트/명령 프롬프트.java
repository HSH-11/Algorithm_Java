import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String[] files = new String[N];
        
        for (int i = 0; i < N; i++) {
            files[i] = sc.next();
        }
        
        StringBuilder pattern = new StringBuilder(files[0]);
        int length = pattern.length();
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < length; j++) {
                if (pattern.charAt(j) != files[i].charAt(j)) {
                    pattern.setCharAt(j, '?');
                }
            }
        }
        
        System.out.println(pattern.toString());
    }
}