import java.io.*;
import java.util.*;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 4; i<=100; i++) {
			dp[i] = dp[i-2]+dp[i-3];
		}
		StringBuilder sb = new StringBuilder();
				
		for (int i = 0; i < T; i++) {
			 sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb.toString());
	
	}
}
