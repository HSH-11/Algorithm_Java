import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E;
	static Edge[] edges;
	static int[] parent;
	
	static class Edge {
		int v1,v2,c;

		public Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V];
		edges =  new Edge[E];
		
		
		// 간선 리스트 초기화
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(v1,v2,c);
		}
		
		
		// 부모 노드를 초기화
		makeSet();
		
		Arrays.sort(edges,(e1,e2)->e1.c-e2.c);
		
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < edges.length; i++) {
			Edge edge = edges[i];
			
			if (union(edge.v1,edge.v2)) {
				cnt++;
				sum += edge.c;
				if (cnt == V-1) break;
			}
		}
		
		System.out.println(sum);
		
					
	}
	
	static void makeSet() {
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if (parent[x] == x) return x;
		return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) return false;
		if (px < py) parent[py] = px;
		else parent[px] = py;
		
		
		return true;
	}

}
