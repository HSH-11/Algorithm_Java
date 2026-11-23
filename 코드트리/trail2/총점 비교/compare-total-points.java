import java.util.Scanner;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int score1, score2, score3;

    public Student(String name, int score1, int score2, int score3) {
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    @Override 
    public int compareTo(Student student) {
        return (this.score1 + this.score2 + this.score3) - (student.score1 + student.score2 + student.score3);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();

            students[i] = new Student(name, score1, score2, score3);
        }
        
        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students[i].name + " " + students[i].score1 + " " + students[i].score2 + " " + students[i].score3);
        }
    }
}