import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		int answer = Integer.MAX_VALUE;

		// 모든 8 X 8 탐색
		for (int si = 0; si + 7 < N; si++) {
			for (int sj = 0; sj + 7 < M; sj++) {
				int mismatchW = 0;

				for (int r = si; r < si + 8; r++) {
					for (int c = sj; c < sj + 8; c++) {
						// 좌표 si,sj 기준 짝수 칸에서 떨어진 위치는 W 홀수 칸은 B
						// 현재 좌표의 짝/홀 여부와 기준 시작점(si,sj)의 짝/홀 여부가 같으면 같은색
						char expected = ((r + c) % 2 == (si + sj) % 2) ? 'W' : 'B';
						if (board[r][c] != expected)
							mismatchW++;
					}
				}

				// 'B' 시작으로 불일치
				int repaint = Math.min(mismatchW, 64 - mismatchW);
				answer = Math.min(answer, repaint);
			}
		}
		System.out.println(answer);
	}

}
