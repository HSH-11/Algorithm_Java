import java.lang.annotation.Native;
import java.util.Arrays;
import java.util.Scanner;

class Number implements Comparable<Number> {
    int value;
    int index;

    public Number(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Number n) {
        return this.value - n.value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Number[] arr = new Number[n];
        
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            arr[i] = new Number(num, i);
        }
        
        Arrays.sort(arr);

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[arr[i].index] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}