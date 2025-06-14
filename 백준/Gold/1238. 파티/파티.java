import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
	
	
	static int N, M, X;
	
	static ArrayList<Edge>[] graph;
	static ArrayList<Edge>[] reverseGraph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 학생  
		M = Integer.parseInt(st.nextToken()); // 도로
		X = Integer.parseInt(st.nextToken()); // 파티 장소
		
		graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		
		// 그래프 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Edge(end,time));
			reverseGraph[end].add(new Edge(start,time));
		}
		
		// x -> i
		int[] fromX = dijkstra(X, graph);
		
		// i -> x
		int[] toX = dijkstra(X, reverseGraph);
		
		int max = 0;
		
		for (int i = 1; i <= N; i++) {
            max = Math.max(max, toX[i] + fromX[i]);
        }
		
		System.out.println(max);
	}
	
	static int[] dijkstra(int start, ArrayList<Edge>[] g) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<Main.Edge>();
		pq.offer(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if (dist[now.to] < now.cost) continue;
			
			for (Edge next : g[now.to]) {
				if (dist[next.to] > dist[now.to] + next.cost ) {
					dist[next.to] = dist[now.to] + next.cost;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
}