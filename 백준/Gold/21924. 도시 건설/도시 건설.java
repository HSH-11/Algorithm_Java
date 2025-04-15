import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 그래프 초기화
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		long sum = 0L;
		// 간선 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, c));
			graph[v].add(new Node(u, c));

			sum += c;
		}

		long mstCost = 0L;
		visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);

		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int curr_v = curr.v; // 도착 노드
			int curr_c = curr.c; // 간선 비용

			// 이미 방문한 노드면 건너뛰기
			if (visited[curr_v])
				continue;

			// 방문하지 않은 노드면 추가
			visited[curr_v] = true;
			mstCost += curr_c;

			// 현재 노드와 연결된 다른 노드들을 큐에 삽입
			for (Node next : graph[curr_v]) {
				if (!visited[next.v]) {
					pq.add(new Node(next.v, next.c));
				}
			}
		}

		int answer = 0;

		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				answer++;
		}

		System.out.println(answer > 0 ? -1 : sum - mstCost);

	}

}
