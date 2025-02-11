import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N-1; i++) {//n-1개
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
		}

		parent = new int[N + 1];

		bfs(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}

	}
	static void bfs(int start) {
		Queue<Integer> queue =  new  ArrayDeque<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for (int next : graph[curr]) {
				if (parent[next] == 0) {
					parent[next] = curr;
					queue.add(next);
				}
			}
		}
	}

}