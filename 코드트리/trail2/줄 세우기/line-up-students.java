import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
    int height, weight, number;

    public Student (int height, int weight, int number) {
        this.height = height;
        this.weight = weight;
        this.number = number;
    }

    @Override
    public int compareTo (Student student) {
        if (this.height == student.height) {
            if (this.weight == student.weight) {
                return this.number - student.number;
            }

            return student.weight - this.weight;
        }

        return student.height - this.height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();

            students[i] = new Student(height, weight, i + 1);
        }
        
        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].number);
        }

        
    }
}