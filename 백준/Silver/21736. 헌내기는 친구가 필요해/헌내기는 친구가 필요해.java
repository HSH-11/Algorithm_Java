import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') {
					int result = bfs(i, j);
					if (result == 0) {
						System.out.println("TT");
					}
					else {
						System.out.println(result);
					}
					return;
				}
			}
		}

	}

	static int bfs(int y, int x) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { y, x });
		visited[y][x] = true;
		int friends = 0;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int cy = pos[0];
			int cx = pos[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				
				if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[ny][nx] == 'X' || visited[ny][nx]) continue;
				
				if (map[ny][nx] == 'P') friends++;
				
				queue.add(new int[] {ny,nx});
				visited[ny][nx] = true;
				
			}
		}
		return friends;
	}
}