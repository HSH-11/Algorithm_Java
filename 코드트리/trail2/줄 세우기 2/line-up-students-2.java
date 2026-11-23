import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    int num, height, weight;

    public Student (int num, int height, int weight) {
        this.num = num;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo (Student student) {
        if (height != student.height) {
            return height - student.height;
        }

        return student.weight - weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int num = i + 1;

            students[i] = new Student(num, h, w);
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].num);
        }
        

    }
}
