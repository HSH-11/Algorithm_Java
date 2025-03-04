import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static long A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B, C));	

	}
	static long pow(long base, long exp, long mod) {
        if (exp == 0) return 1; // A^0 = 1
        long half = pow(base, exp / 2, mod);
        long result = (half * half) % mod;
        if (exp % 2 == 1) result = (result * base) % mod; // B가 홀수이면 추가 곱셈
        return result;
    }
}