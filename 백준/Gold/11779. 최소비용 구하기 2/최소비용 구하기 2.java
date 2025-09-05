import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static ArrayList<Edge>[] graph;
	static int[] dist, parent;
	static final int INF = Integer.MAX_VALUE;

	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Main.Edge>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, cost));

		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		Dijkstra(start);

		// 최소 비용
		System.out.println(dist[end]);
		// 경로 추적
		Stack<Integer> stack = new Stack<>();
		for (int i = end; i != 0; i = parent[i]) {
			stack.push(i);
		}

		System.out.println(stack.size());

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

	static void Dijkstra(int start) {
		dist = new int[n + 1];
		parent = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<Main.Edge>();
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.cost > dist[cur.to])
				continue;

			for (Edge next : graph[cur.to]) {
				if (dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					parent[next.to] = cur.to;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
	}
}
