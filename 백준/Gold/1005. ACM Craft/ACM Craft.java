import java.io.*;
import java.util.*;

// 그래프 관점에서 DAG(사이클 없는 방향 그래프) + 위상 정렬 + DP(최장 경로) 조합으로 푸는 문제.

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] cost = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			List<Integer>[] graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				graph[i] = new ArrayList<Integer>();

			int[] indegree = new int[N + 1];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				indegree[v]++;
			}

			int W = Integer.parseInt(br.readLine().trim());

			// 위상 정렬 + DP (최장 경로)
			int[] dp = new int[N + 1];
			ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

			for (int i = 1; i <= N; i++) {
				dp[i] = cost[i];
				if (indegree[i] == 0)
					queue.add(i);
			}

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : graph[cur]) {
					// cur까지 걸린 시간 + next 공사 시간
					if (dp[next] < dp[cur] + cost[next]) {
						dp[next] = dp[cur] + cost[next];
					}
					if (--indegree[next] == 0) // 해당 건물의 선행 건물이 다 지어져야만 queue 삽입 가능
						queue.add(next);
				}
			}
			sb.append(dp[W]).append("\n");
		}
		System.out.println(sb);
	}

}
