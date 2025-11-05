import java.io.*;
import java.util.*;

public class Main {

	// 시계방향
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] visited;
	static int src_y, src_x, tgt_y, tgt_x;
	static int I;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			I = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 나이트 현재 위치
			src_y = Integer.parseInt(st.nextToken());
			src_x = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			// 나이트가 이동하려는 칸
			tgt_y = Integer.parseInt(st.nextToken());
			tgt_x = Integer.parseInt(st.nextToken());

			visited = new boolean[I][I];

			int result = bfs();
			sb.append(result).append("\n");

		}
		System.out.println(sb);
	}

	static int bfs() {
		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { src_y, src_x, 0 });
		visited[src_y][src_x] = true;
		int result = 0;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int y = pos[0];
			int x = pos[1];
			int cnt = pos[2];

			for (int d = 0; d < 8; d++) {
				int curY = dy[d] + y;
				int curX = dx[d] + x;


				if (curY < 0 || curY >= I || curX < 0 || curX >= I)
					continue;
				

				if (!visited[curY][curX]) {
					if (curY == tgt_y && curX == tgt_x) {
						result = cnt + 1;
						return result;
					}
					queue.add(new int[] { curY, curX, cnt + 1 });
					visited[curY][curX] = true;
				}
			}
		}
		return result;

	}
}
