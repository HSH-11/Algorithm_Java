import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long sum; // 간선의 가중치의 합
	static int[][] adjMatrix;
	static boolean[] visit;

	static PriorityQueue<Vertex> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));


	static class Vertex {
		int vertex;
		int cost;

		Vertex(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[N];
		sum = 0;
		
		pq.add(new Vertex(0,0));
		
		while(!pq.isEmpty()) {
			Vertex curr = pq.poll();
			int node = curr.vertex;
			int cost = curr.cost;
			
			if (visit[node]) continue;
			
			visit[node] = true;
			sum += cost;
			
			for (int nextNode = 0; nextNode < N; nextNode++) {
				if (node != nextNode && !visit[nextNode] && adjMatrix[node][nextNode] != 0){
					pq.add(new Vertex(nextNode,adjMatrix[node][nextNode]));
				}
			}
		}
		System.out.println(sum);

	}

}
