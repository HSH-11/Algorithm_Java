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

        // Arrays.sort(profiles, (a,b) -> a.name.compareTo(b.name));
        int lastIdx = 0;
        for(int i = 1; i < n; i++) {
            if(profiles[i].name.compareTo(profiles[lastIdx].name) > 0)
                lastIdx = i;
        }

        System.out.println("name " + profiles[lastIdx].name);
        System.out.println("addr " + profiles[lastIdx].address);
        System.out.println("city " + profiles[lastIdx].region);
        
    }
}
