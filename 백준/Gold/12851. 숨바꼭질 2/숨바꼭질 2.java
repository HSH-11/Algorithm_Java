import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = 100001;
	static int result = 0;
	static int[] visited;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		bfs(N, K);
		System.out.println(dist[K]);
		System.out.println(visited[K]);

	}

	static void bfs(int start, int target) {
		visited = new int[MAX];
		dist = new int[MAX];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		visited[start] = 1;
		dist[start] = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();


			for (int next : new int[] { cur - 1, cur + 1, cur * 2 }) {
				if (next >= 0 && next < MAX) {
					// 처음 방문하는 경우
					if (visited[next] == 0) {
						queue.add(next);
						dist[next] = dist[cur] + 1;
						visited[next] = visited[cur];
				
					}

					// 이미 방문한 적 있지만, 최단 거리로 도달할 수 있는 또 다른 경우
	                else if (dist[next] == dist[cur] + 1) {
	                    visited[next] += visited[cur];
	                }
				}
			}

		}

	}
}
