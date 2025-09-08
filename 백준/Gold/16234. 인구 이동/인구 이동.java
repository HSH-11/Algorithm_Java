import java.io.*;
import java.util.*;

public class Main {

	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 0;

		while (true) {
			visited = new boolean[N][N];
			boolean moved = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if (bfs(i, j))
							moved = true;
					}
				}
			}

			if (!moved)
				break;
			days++;
		}
		System.out.println(days);

	}

	static boolean bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		List<Point> union = new ArrayList<Main.Point>();

		q.add(new Point(y, x));
		union.add(new Point(y, x));
		visited[y][x] = true;

		int sum = map[y][x];

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[ny][nx])
					continue;

				int diff = Math.abs(map[p.y][p.x] - map[ny][nx]);

				if (L <= diff && diff <= R) {
					q.add(new Point(ny, nx));
					union.add(new Point(ny, nx));
					visited[ny][nx] = true;
					sum += map[ny][nx];
				}
			}
		}

		if (union.size() <= 1)
			return false;

		int newPopulation = sum / union.size();
		for (Point p : union) {
			map[p.y][p.x] = newPopulation;
		}

		return true;
	}

}
