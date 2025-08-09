import java.io.*;
import java.util.*;

public class Main {
	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static List<Pos> houses = new ArrayList<Main.Pos>();
	static List<Pos> chickens = new ArrayList<Main.Pos>();
	static int[][] dist;
	static int H, C;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (v == 1)
					houses.add(new Pos(i, j));
				else if (v == 2)
					chickens.add(new Pos(i, j));
			}
		}

		H = houses.size();
		C = chickens.size();

		dist = new int[H][C];
		for (int i = 0; i < H; i++) {
			Pos h = houses.get(i);
			for (int j = 0; j < C; j++) {
				Pos ch = chickens.get(j);
				dist[i][j] = Math.abs(h.r - ch.r) + Math.abs(h.c - ch.c);
			}
		}

		// 조합으로 치킨집 M개 선택
		int[] picked = new int[M];
		combine(0, 0, picked);

		System.out.println(result);

	}

	static void combine(int idx, int start, int[] picked) {
		if (idx == M) {
			int sum = 0;
			for (int h = 0; h < H; h++) {
				int minD = Integer.MAX_VALUE;
				for (int k = 0; k < M; k++) {
					int chIdx = picked[k];
					minD = Math.min(minD, dist[h][chIdx]);
					// 가지치기: 이미 0이면 더 볼 필요 없음
					if (minD == 0)
						break;
				}
				// 모든 집의 최소 거리를 더해 도시 치킨 거리를 계산
				sum += minD;
				// 가지치기: 이미 현재 최적보다 커지면 중단
				if (sum >= result)
					return;
			}
			result = Math.min(result, sum);
			return;
		}

		for (int i = start; i < C; i++) {
			picked[idx] = i;
			combine(idx + 1, i + 1, picked);
		}
	}

}
