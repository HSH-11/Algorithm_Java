import java.io.*;
import java.util.*;

public class Main {
	
	static int N, p1, p2;
	static ArrayList<Integer>[] relation;
	static boolean[] visited;
	static int[] depth;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		relation = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			relation[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x].add(y);
			relation[y].add(x);
		}
		visited = new boolean[N+1];
		depth = new int[N+1];
		
		dfs(p1,0);
		System.out.println(depth[p2] == 0 ? -1 : depth[p2]);
		
	}
	
	static void dfs (int start, int level) {
		visited[start] = true;
		depth[start] = level;
		
		if (start == p2) return;
				
		for (int next : relation[start]) {
			if (!visited[next]) {
					dfs(next, level + 1);		
			}
		}
		
	}

}
