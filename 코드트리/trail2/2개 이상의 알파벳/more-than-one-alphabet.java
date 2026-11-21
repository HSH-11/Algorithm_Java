import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        
        System.out.print(func(A) ? "Yes" : "No");
    
    }

    public static boolean func (String s) {
        HashSet <Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (set.size() >= 2) {
                return true;
            } 
        }

        return false;
    }
}