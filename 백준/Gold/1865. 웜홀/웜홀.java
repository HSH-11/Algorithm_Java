import java.io.*;
import java.util.*;

class Edge {
	int from, to, cost;

	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

}

public class Main {
	static final int INF = 1_000_000_000;
	static int N, M, W;
	static List<Edge> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			edges = new ArrayList<Edge>();
			
			// 도로 (양방향)
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edges.add(new Edge(S,E,T));
				edges.add(new Edge(E,S,T));
			}
			
			// 웜홀 (단방향)
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edges.add(new Edge(S,E,-T));
			}
			
			// 가상 시작점(0번)에서 모든 노드로 0비용 간선 추가
            for (int i = 1; i <= N; i++) {
                edges.add(new Edge(0, i, 0));
            }
			
			System.out.println(bellmanFord(0) ? "YES" : "NO");
		}

	}
	
	static boolean bellmanFord(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		// 가상 노드 포함 N번 반복
		for (int i = 0; i < N;i++) {
			for (Edge edge : edges) {
				if (dist[edge.from] != INF && dist[edge.from] + edge.cost < dist[edge.to]) {
					dist[edge.to] = dist[edge.from] + edge.cost;
				}
			}
		}
		
		// 음수 사이클 확인
        for (Edge edge : edges) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                return true; // 음수 사이클 존재
            }
        }
		
		return false;
	}
}
