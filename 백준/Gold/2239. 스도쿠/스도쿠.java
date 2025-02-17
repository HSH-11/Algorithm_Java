import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] board;

	static class Block {
		int y, x;

		public Block(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}

		findSolution();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	static Block findEmpty() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					return new Block(i, j);
				}
			}
		}
		return null;
	}

	static boolean findSolution() {
		Block pos = findEmpty();
		
		if (pos == null)
			return true;

		int row = pos.y;
		int col = pos.x;

		for (int num = 1; num <= 9; num++) {
			if (is_valid(num, row, col)) {
				board[row][col] = num;
				if (findSolution()) {
					return true;
				}
				board[row][col] = 0;
			}
		}
		return false;
	}

	static boolean is_valid(int num, int row, int col) {
		int boxRow = (row / 3) * 3;
		int boxCol = (col / 3) * 3;

		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num)
				return false; 
			if (board[i][col] == num)
				return false; 
			if (board[boxRow + i / 3][boxCol + i % 3] == num)
				return false; 
		}
		return true;
	}

}
