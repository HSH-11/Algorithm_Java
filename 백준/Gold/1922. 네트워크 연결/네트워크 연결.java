import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	
	static int N,M;
	static Edge[] edges;
	static int[] parent;
	
	
	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int i) {
		if (parent[i] == i) return i;
		
		return parent[i] = findSet(parent[i]);
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) return false;
		else if (px >= py) {
			parent[px] = py;
		}else {
			parent[py] = px;
		}
		return true;
	}
	
	static class Edge {
		int u,v,c;

		public Edge(int u, int v, int c) {
			this.u = u;
			this.v = v;
			this.c = c;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		M = Integer.parseInt(br.readLine()); // 선 개수
		
		parent = new int[N+1];
		edges = new Edge[M];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(u,v,c);
			
		}
		
		makeSet();
		
		Arrays.sort(edges,(e1,e2)->(e1.c-e2.c));
		
		int weight = 0;
		int edgesUsed = 0;
		
		for (int i = 0; i < M; i++) {
			Edge now = edges[i];
			if (findSet(now.u) == findSet(now.v)) continue; // 같은 집합에 속함(이미 연결되어 있음)
			weight += now.c;
			union(now.u,now.v);
			edgesUsed++;
			
			if (edgesUsed == N - 1) {
				break;
			}
		}
		
		System.out.println(weight);
	}

}
