import java.io.*;
import java.util.*;

public class Main {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] dy = { 0, 0, -1, 1 }; // 동,서,북,남
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dice = new int[6]; // 0:위,1:북,2:동,3:서,4:남,5:아래

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken()); // 세로 좌표 (행)
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < K; k++) {
			int cmd = Integer.parseInt(st.nextToken()) - 1; // 동서북남
			int ny = y + dy[cmd];
			int nx = x + dx[cmd];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M)
				continue;

			// 주사위 회전
			roll(cmd);

			// 이동한 칸에 쓰여 있는 수가 0인지 확인
			if (map[ny][nx] == 0) {
				map[ny][nx] = dice[5];
			} else {
				dice[5] = map[ny][nx];
				map[ny][nx] = 0;
			}

			sb.append(dice[0]).append("\n");

			// 좌표 갱신
			y = ny;
			x = nx;

		}
		
		System.out.println(sb);

	}

	static void roll(int dir) {
		int temp;
		switch (dir) {
		case 0: // 동쪽 (동쪽에 있던게 바텀으로)
			temp = dice[0]; // top
			dice[0] = dice[3]; // west -> top
			dice[3] = dice[5]; // bottom -> west
			dice[5] = dice[2]; // east -> bottom
			dice[2] = temp; // top -> east
			break;
		case 1: // 서쪽
			temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
			break;
		case 2: // 북쪽
			temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
			break;
		case 3: // 남쪽
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
			break;
		}
	}

}