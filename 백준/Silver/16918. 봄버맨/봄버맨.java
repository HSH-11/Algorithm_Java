import java.io.*;
import java.util.*;

public class Main {

	static int R, C, N;
	static char[][] board;
	static int[][] times;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class Bomb {
		int y;
		int x;

		public Bomb(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		times = new int[R][C];

		int time = 0;

		Queue<Bomb> queue = new ArrayDeque<Main.Bomb>();

		// 초기 상태 및 1초 후
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == '.') {
					board[i][j] = '.';
				} else if (line.charAt(j) == 'O') {
					board[i][j] = 'O';
					times[i][j] = time;
				}
			}
		}

		time++;

		while (time < N) {

			// 2초 후: 폭탄이 설치되어 있지 않은 모든 칸 폭탄 설치
			time++;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (board[i][j] == '.') {
						board[i][j] = 'O';
						times[i][j] = time;
					}
					if (board[i][j] == 'O' && time - times[i][j] >= 2) {
						queue.add(new Bomb(i, j));
					}
				}
			}
			if (time >= N)
				break;

			// 3초 후: 인접 폭탄 폭발
			time++;
			while (!queue.isEmpty()) {
				Bomb bomb = queue.poll();
				int cy = bomb.y;
				int cx = bomb.x;
				
				board[cy][cx] = '.';

				for (int d = 0; d < 4; d++) {
					int ny = cy + dy[d];
					int nx = cx + dx[d];

					if (ny < 0 || ny >= R || nx < 0 || nx >= C)
						continue;

					board[ny][nx] = '.';
				}
			}

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

}
