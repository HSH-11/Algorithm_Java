import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static final int INF = 1000000;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		// 친구 관계 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		int minKevinBacon = INF;
		int result = -1;

		for (int i = 1; i <= N; i++) {
			int kevinBacon = bfs(i);
			if (kevinBacon < minKevinBacon) {
				minKevinBacon = kevinBacon;
				result = i;
			}
		}

		System.out.println(result);

	}

	static int bfs(int start) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph[cur]) {
				if (dist[next] == INF) {
					dist[next] = dist[cur] + 1;
					q.offer(next);
				}
			}
		}

		// 모든 사람과의 dist 합
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == INF)
				return INF;
			sum += dist[i];
		}
		return sum;
	}
}
