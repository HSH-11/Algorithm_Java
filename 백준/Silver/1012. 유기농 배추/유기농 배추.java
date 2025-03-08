import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//배추의 위치에서 BFS탐색

public class Main {

	static int T, M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int result;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			result = 0;
			map = new int[N][M];
			visited = new boolean[N][M];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (map[y][x] == 1 && !visited[y][x]) {
						bfs(y, x);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	static void bfs(int y, int x) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { y, x });
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int cy = pos[0];
			int cx = pos[1];
			

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || map[ny][nx] == 0)
					continue;

				queue.add(new int[] { ny, nx });
				visited[ny][nx] = true;
			}
		}

	}
}