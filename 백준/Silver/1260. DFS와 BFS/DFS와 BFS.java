import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
			
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[n+1];
		dfs(v);
		sb.append("\n");
		
		visited = new boolean[n+1];
		bfs(v);
		
		System.out.println(sb);
		
	}
	
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		for (int next : graph[v]) {
			if(visited[next] == false) {
				dfs(next);
			}
			
		}
	}
	static void bfs(int v) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");
			for (int next : graph[curr]) {
				if (visited[next] == false) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}
}