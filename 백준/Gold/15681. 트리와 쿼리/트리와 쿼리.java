import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, R, Q;
	static ArrayList<Integer>[] adj;
	static int[] dp;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		dp = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}

		dfs(R); // 서브트리 크기 계산

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int queryNode = Integer.parseInt(br.readLine());
			sb.append(dp[queryNode]).append("\n");
		}
		System.out.println(sb);

	}

	static int dfs(int node) {
		visited[node] = true;
		dp[node] = 1;

		for (int child : adj[node]) {
			if (!visited[child]) {
				dp[node] += dfs(child);
			}
		}

		return dp[node];
	}

}