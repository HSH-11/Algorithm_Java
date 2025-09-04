import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int[] prev = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			prev[i] = -1;

		}

		// LIS
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					prev[i] = j; // 경로 저장
				}
			}
		}

		int maxLen = 0;
		int lastIndex = 0;
		for (int i = 0; i < N; i++) {
			if (dp[i] > maxLen) {
				maxLen = dp[i];
				lastIndex = i;
			}
		}

		// 수열 복원
		Stack<Integer> stack = new Stack<Integer>();
		while (lastIndex != -1) {
			stack.push(arr[lastIndex]);
			lastIndex = prev[lastIndex];
		}

		System.out.println(maxLen);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}