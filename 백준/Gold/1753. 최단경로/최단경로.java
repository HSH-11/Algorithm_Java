import java.io.*;
import java.util.*;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int V, E, S;
	static ArrayList<Node>[] graph;
	static int[] dist;

	static class Node implements Comparable<Node> {
		int vertex, weight;

		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine())-1;

		graph = new ArrayList[V];
		dist = new int[V];

		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<Node>();
			dist[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(S);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < V; i++) {
			if (dist[i] == INF) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int curr_vertex = curr.vertex;
			int curr_weight = curr.weight;

			if (curr_weight > dist[curr_vertex])
				continue;

			for (Node next : graph[curr_vertex]) {
				int next_vertex = next.vertex;
				int next_weight = next.weight;

				if (dist[next_vertex] > dist[curr_vertex] + next_weight) {
					dist[next_vertex] = dist[curr_vertex] + next_weight;
					pq.add(new Node(next_vertex, dist[next_vertex]));
				}
			}
		}
	}
}
