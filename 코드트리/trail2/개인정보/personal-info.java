import java.util.Arrays;
import java.util.Scanner;

class Person {
    String name;
    int height;
    double weight;

    public Person (String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;

        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            double weight = sc.nextDouble();

            people[i] = new Person(name, height, weight);
        }
        
        System.out.println("name");
        Arrays.sort(people, (a,b) -> a.name.compareTo(b.name));
        for (int i = 0; i < n; i++) {
            System.out.println(people[i].name + " " + people[i].height + " " + people[i].weight);
        }

        System.out.println();
        
        System.out.println("height");
        Arrays.sort(people, (a,b) -> b.height - a.height);
        for (int i = 0; i < n; i++) {
            System.out.println(people[i].name + " " + people[i].height + " " + people[i].weight);
        }
    }
}