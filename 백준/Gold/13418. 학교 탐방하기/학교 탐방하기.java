import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// 오름차순
			return Integer.compare(this.weight, o.weight);
		}

	}
	
	static int N;
	static List<List<Edge>> graph = new ArrayList<List<Edge>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken()); // 0: 오르막, 1: 내리막

            // 오르막은 피로도 1, 내리막은 0으로 저장
            int weight = (type == 0) ? 1 : 0;

            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
        }

        int minFatigue = prim(true); 
        int maxFatigue = prim(false);

        System.out.println((maxFatigue * maxFatigue) - (minFatigue * minFatigue));
	}
	
	static int prim(boolean Mode) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq;

        // 오르막 우선: 오름차순, 내리막 우선: 내림차순
        if (Mode) {
            pq = new PriorityQueue<>(); // 오르막 먼저
        } else {
            pq = new PriorityQueue<>((a, b) -> Integer.compare(b.weight, a.weight)); // 내리막 먼저
        }

        pq.add(new Edge(0, 0)); // 입구:0
        int count = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;

            // 오르막이라면 카운트 증가 (가중치가 1이면 오르막)
            if (cur.weight == 1) {
                count++;
            }

            for (Edge next : graph.get(cur.to)) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        return count;
    }
}
