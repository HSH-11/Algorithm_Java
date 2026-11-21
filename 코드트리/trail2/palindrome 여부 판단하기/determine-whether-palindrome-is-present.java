import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        System.out.print(isPalindrome(input) ? "Yes" : "No");
    }

    public static boolean isPalindrome (String s) {
        
        int start = 0;
        int last = s.length() - 1;

        while (start <= last) {
            if (s.charAt(start) != s.charAt(last)) {
                return false;
            }

            start++;
            last--;
        }

        return true;
    }
}