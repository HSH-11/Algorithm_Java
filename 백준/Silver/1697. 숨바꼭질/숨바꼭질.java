import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] dx = { -1, 1, 2 };
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			return;
		} else if (N > K) {
			System.out.println(N - K);
			return;
		} else {
			System.out.println(bfs());

		}
	}

	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { N, 0 });
		visited[N] = true;

		while (!queue.isEmpty()) {
			int pos[] = queue.poll();
			int cx = pos[0];
			int time = pos[1];

			for (int i = 0; i < 3; i++) {
				int nx;
				if (i == 2) {
					nx = cx * dx[i];
				} else {
					nx = cx + dx[i];
				}
				if (nx < 0 || nx > 100000 || visited[nx])
					continue;

				if (nx == K) {
					return time + 1;
				}
				queue.add(new int[] { nx, time + 1 });
				visited[nx] = true;
			}
		}
		return -1;
	}

}