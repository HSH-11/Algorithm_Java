import java.util.Scanner;
import java.util.Arrays;

class User {
    char codeName;
    int score;
}

public class Main {
    public static final int MAX_N = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User[] users = new User[MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            users[i] = new User();
            users[i].codeName = sc.next().charAt(0);
            users[i].score = sc.nextInt();
        }

        Arrays.sort(users, (a,b) -> a.score - b.score);

        System.out.print(users[0].codeName + " " + users[0].score);
    }
}
