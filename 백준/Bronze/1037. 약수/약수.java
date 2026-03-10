import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt(); // 약수의 개수
        int[] divisors = new int[count];
        
        for (int i = 0; i < count; i++) {
            divisors[i] = sc.nextInt();
        }
        
        // 1. 정렬하여 최솟값과 최댓값을 찾음
        Arrays.sort(divisors);
        
        // 2. 최솟값 * 최댓값 = 원래 숫자 N
        // 결과가 2^31-1보다 클 수 있으므로 long 사용 권장 (이 문제는 int로도 가능)
        long result = (long) divisors[0] * divisors[count - 1];
        
        System.out.println(result);
    }
}