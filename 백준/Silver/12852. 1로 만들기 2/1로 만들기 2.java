import java.io.*;
import java.util.*;

public class Main {
	static int[] dp;
	static int[] from;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];
		from = new int[N + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[N] = 0;

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			// 다음으로 갈 수 있는 세 가지 경우
			for (int next : new int[] { cur / 3, cur / 2, cur - 1 }) {
				if (next < 1)
					continue;

				if ((cur % 3 == 0 && next == cur / 3) || (cur % 2 == 0 && next == cur / 2) || (next == cur - 1)) {

					if (dp[next] > dp[cur] + 1) {
						dp[next] = dp[cur] + 1;
						from[next] = cur;
						queue.offer(next);
					}
				}
			}
		}

		// 최소 연산 횟수
		System.out.println(dp[1]);
		
		// 경로 추적
		Stack<Integer> stack = new Stack<>();
        int cur = 1;
        while (cur != 0) {
            stack.push(cur);
            cur = from[cur];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

	}
}
