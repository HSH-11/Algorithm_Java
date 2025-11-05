import java.io.*;
import java.util.*;
import java.math.BigInteger;

// 임의 정밀도를 지원하는 BigInteger 클래스 사용
// 분자와 분모 나누면서 계산
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		System.out.println(Combination(n, m));

	}

	static BigInteger Combination(int n, int m) {
        // m이 n/2보다 크면, C(n, m) = C(n, n-m) 이므로 더 작은 m 선택
        if (m > n - m) {
            m = n - m;
        }

        BigInteger result = BigInteger.ONE;
        
        // 분자 부분 (n * (n-1) * ... * (n-m+1))
        for (int i = 0; i < m; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));  // n, n-1, ..., n-m+1 곱셈
            result = result.divide(BigInteger.valueOf(i + 1));    // m!로 나누기
        }

        return result;
    }

}
