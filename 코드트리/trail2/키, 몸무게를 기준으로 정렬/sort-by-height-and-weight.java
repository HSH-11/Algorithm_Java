import java.util.Arrays;
import java.util.Scanner;

class Person implements Comparable<Person>{
    String name;
    int height;
    int weight;

    public Person (String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo (Person person) {

        if (this.height == person.height)
            return person.weight - this.weight;

        return this.height - person.height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            people[i] = new Person(name, height, weight);
        }

        Arrays.sort(people);

        for (int i = 0; i < n; i++) {
            System.out.println(people[i].name + " " + people[i].height + " " + people[i].weight);
        }        
    }
}
