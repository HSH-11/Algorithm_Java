import java.io.*;
import java.util.*;


public class Main {

	static final int INF = 1000;
	static int N;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N + 1][N + 1];
		
		
		for (int i = 1; i <=N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1) break;
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		int[] scores = new int[N+1];
		int minScore = INF;
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] != INF) {
					max = Math.max(max, dist[i][j]);
				}
			}
			scores[i] = max;
			minScore = Math.min(minScore,max);
		}
		
		List<Integer> candidates = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (scores[i] == minScore) {
				candidates.add(i);
			}
		}
		
		System.out.println(minScore + " " + candidates.size());
		for (int c :candidates) {
			System.out.print(c+ " ");
		}
	}

}
