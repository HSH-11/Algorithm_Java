import java.util.Scanner;
import java.util.Arrays;

class Profile {
    String name;
    String address;
    String region;

    public Profile (String name, String address, String region) {
        this.name = name;
        this.address = address;
        this.region = region;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Profile[] profiles = new Profile[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String address = sc.next();
            String region = sc.next();

            profiles[i] = new Profile(name, address, region);
        }

        Arrays.sort(profiles, (a,b) -> a.name.compareTo(b.name));

        System.out.println("name " + profiles[n-1].name);
        System.out.println("addr " + profiles[n-1].address);
        System.out.println("city " + profiles[n-1].region);
        
    }
}
