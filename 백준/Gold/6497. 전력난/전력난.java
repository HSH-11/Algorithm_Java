
import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int v, c;

		public Node(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static int m, total;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if (m == 0 && n == 0) break;
			graph = new ArrayList[m];
			for (int i = 0; i < m; i++) {
				graph[i] = new ArrayList<Main.Node>();
			}

			total = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());

				graph[x].add(new Node(y, z));
				graph[y].add(new Node(x, z));
				total += z;
			}

			System.out.println(total - prim());
		}
	}

	static int prim() {

		int totalCost = 0;
		visited = new boolean[m];
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>((o1, o2) -> o1.c - o2.c);

		pq.add(new Node(0, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int curr_v = curr.v;
			int curr_c = curr.c;

			if (visited[curr_v])
				continue;

			visited[curr_v] = true;
			totalCost += curr_c;

			for (Node next : graph[curr_v]) {
				if (!visited[next.v]) {
					pq.add(new Node(next.v, next.c));
				}
			}
		}

		return totalCost;
	}
}
