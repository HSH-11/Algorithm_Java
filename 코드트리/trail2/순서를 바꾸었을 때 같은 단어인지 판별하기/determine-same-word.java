import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        
        if(word1.length() != word2.length()) {
            System.out.print("No");
            return;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        String sorted1 = new String(chars1);
        String sorted2 = new String(chars2);

        if (sorted1.equals(sorted2))  System.out.print("Yes");
        else System.out.print("No");       
    }
}