import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int L = sc.nextInt();

        // 수열의 길이를 L부터 100까지 하나씩 늘려가며 확인
        for (int l = L; l <= 100; l++) {
            // lx = N - l*(l-1)/2  공식 이용
            long temp = N - (long) l * (l - 1) / 2;

            // x가 음수가 되면 안 됨
            if (temp < 0) break;

            // x가 정수여야 함 (나누어떨어져야 함)
            if (temp % l == 0) {
                long x = temp / l;
                
                for (int i = 0; i < l; i++) {
                    System.out.print((x + i) + " ");
                }
                return; // 가장 먼저 찾은 최소 길이 l에서 종료
            }
        }

        System.out.println("-1");
    }
}