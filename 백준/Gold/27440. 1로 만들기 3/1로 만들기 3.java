import java.io.*;
import java.util.*;

public class Main {

	
	static Map<Long, Integer> memo = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		System.out.println(solve(N));
		
	}
	
	static int solve(long n) {
		
		if (n <= 1) return 0;
		if (n == 2 || n == 3) return 1;
		
		
		if (memo.containsKey(n)) return memo.get(n);
		
		// 10을 3으로 나누려면 1을 한번 빼서 9로 만들어야함 나머지 만큼 1을 빼는 비용 발생
		// n을 2로 나누기 위해 (n % 2)만큼 1을 빼는 비용 + 1(나누기 연산) + solve(n/2)
        // n을 3으로 나누기 위해 (n % 3)만큼 1을 빼는 비용 + 1(나누기 연산) + solve(n/3)
		
		int res = 1 + Math.min((int)(n % 2) + solve(n / 2), (int)(n % 3) + solve(n / 3));
		
		memo.put(n, res);
		return res;
		
	}

}