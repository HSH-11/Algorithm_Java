import java.io.*;
import java.util.*;

// Point: 배열 변화 상태 관리 
public class Main {

	static int R, C, T;
	static int[][] map;
	static int[][] temp;
	static int top, bottom;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		boolean find = false; // 공기청정기 위치 확인

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && !find) {
					top = i;
					bottom = i + 1;
					find = true;
				}
			}
		}

		while (T-- > 0) {
			spread(); // 확산
			purify(); // 정화
		}

		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					sum += map[i][j];
			}
		}

		System.out.println(sum);
	}

	static void spread() {
		temp = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int amount = map[i][j] / 5;
					int count = 0;

					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1)
							continue;

						temp[nx][ny] += amount;
						count++;
					}
					temp[i][j] += map[i][j] - (amount * count);
				} else if (map[i][j] == -1) {
					temp[i][j] = -1;
				}
			}
		}
		map = temp;
	}

	static void purify() {
		// 위쪽 반시계 방향 순환
		for (int i = top - 1; i > 0; i--)
			map[i][0] = map[i - 1][0];
		for (int i = 0; i < C - 1; i++)
			map[0][i] = map[0][i + 1];
		for (int i = 0; i < top; i++)
			map[i][C - 1] = map[i + 1][C - 1];
		for (int i = C - 1; i > 1; i--)
			map[top][i] = map[top][i - 1];
		map[top][1] = 0;
		// 오른쪽 시계 방향
		for (int i = bottom + 1; i < R - 1; i++)
			map[i][0] = map[i + 1][0];
		for (int i = 0; i < C - 1; i++)
			map[R - 1][i] = map[R - 1][i + 1];
		for (int i = R - 1; i > bottom; i--)
			map[i][C - 1] = map[i - 1][C - 1];
		for (int i = C - 1; i > 1; i--)
			map[bottom][i] = map[bottom][i - 1];
		map[bottom][1] = 0;

	}
}
