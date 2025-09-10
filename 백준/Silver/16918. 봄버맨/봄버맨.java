import java.io.*;
import java.util.*;

public class Main {

	static int R, C, N;
	static char[][] board;
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
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		if (N == 1) {
			printBoard(board);
			return;
		}

		if (N % 2 == 0) {
			fillBoardWithBombs();
			printBoard(board);
			return;
		}

		// 1차 폭발 후 상태 (3초)
		char[][] afterFirstBoom = simulate(board);

		if (N % 4 == 3) {
			printBoard(afterFirstBoom);
		} else { // N % 4 == 1
			char[][] afterSecondBoom = simulate(afterFirstBoom);
			printBoard(afterSecondBoom);
		}

	}

	static char[][] simulate(char[][] input) {
		char[][] full = new char[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(full[i], 'O');
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (input[i][j] == 'O') {
					full[i][j] = '.';
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
							full[ny][nx] = '.';
						}
					}
				}
			}
		}
		return full;
	}

	static void fillBoardWithBombs() {
		for (int i = 0; i < R; i++) {
			Arrays.fill(board[i], 'O');
		}
	}

	static void printBoard(char[][] b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			sb.append(b[i]).append('\n');
		}
		System.out.print(sb);
	}

}
