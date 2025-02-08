import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
		
		for (int i = 1; i < N; i++) {//num
			for (int j = 0; j < i; j++) {
				if (num[i] > num[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		System.out.println(Arrays.stream(dp).max().getAsInt());
		
	}

}