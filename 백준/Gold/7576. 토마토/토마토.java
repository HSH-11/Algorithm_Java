import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] box;
	static Deque<int[]> queue = new ArrayDeque<>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];

		int Not_yet = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {// 처음 상자 안에 있는 익은 토마토 큐에 넣음
					queue.add(new int[] { i, j });
				} else if (box[i][j] == 0) {
					Not_yet++;
				}
			}
		}

		if (Not_yet == 0) {
			System.out.println(0);
			return;
		}

		int result = bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(result);
	}

	static int bfs() {
		int maxDays = 0;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0], y = curr[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
					box[nx][ny] = box[x][y] + 1; 
					maxDays = Math.max(maxDays, box[nx][ny] - 1); 
					queue.add(new int[] { nx, ny });
				}
			}
		}
		return maxDays;
	}

	
}