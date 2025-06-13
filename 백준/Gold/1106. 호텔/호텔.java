import java.io.*;
import java.util.*;

public class Main {
	// 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[C+101];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			for (int j = customer; j < dp.length; j++) {
				if (dp[j - customer] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - customer] + cost);
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = C; i < dp.length; i++) {
			result = Math.min(dp[i], result);
		}
		
		System.out.println(result);
		
		
	}
}