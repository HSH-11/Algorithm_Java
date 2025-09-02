import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = 100001;
	static int[] parent = new int[MAX];
	static int[] dist = new int[MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 시간 기록
		Arrays.fill(parent, -1);

		bfs(N, K);

		// 경로 역추적
		Stack<Integer> path = new Stack<>();
		for (int i = K; i != -1; i = parent[i]) {
			path.push(i);
		}

		System.out.println(dist[K]); // 이동 횟수 (= 시간)
		while (!path.isEmpty()) {
			System.out.print(path.pop() + " ");
		}

	}

	static void bfs(int start, int target) {
		boolean[] visited = new boolean[100001];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		visited[start] = true;
		dist[start] = 0;
		parent[start] = -1;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == target)
				return;

			for (int next : new int[] { cur - 1, cur + 1, cur * 2 }) {
				if (next >= 0 && next < MAX && !visited[next]) {
					visited[next] = true;
					queue.add(next);
					parent[next] = cur;
					dist[next] = dist[cur] + 1;
				}
			}

		}

	}
}
