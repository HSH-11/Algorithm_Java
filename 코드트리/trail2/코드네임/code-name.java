import java.util.Scanner;
import java.util.Arrays;

class User {
    char codeName;
    int score;

    public User(char codeName, int score) {
        this.codeName = codeName;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        User[] users = new User[n];
        for (int i = 0; i < n; i++) {
            char codeName = sc.next().charAt(0);
            int score = sc.nextInt();
            
            users[i] = new User(codeName, score);
        }

        // Arrays.sort(users, (a,b) -> a.score - b.score);

        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if(users[minIdx].score > users[i].score)
                minIdx = i;
        }

        System.out.print(users[minIdx].codeName + " " + users[minIdx].score);
    }
}
