import java.io.*;
import java.util.*;

// 가능한 모든 높이를 대상으로 시뮬레이션

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] land = new int[N][M];
		int max = 0; // 땅 높이는 최소 0이상이므로, max보다 큰 값이 나오면 갱신
		int min = 256;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, land[i][j]);
				min = Math.min(min, land[i][j]);
			}
		}

		int resultTime = Integer.MAX_VALUE;
		int resultHeight = 0;

		for (int h = min; h <= max; h++) {
			int remove = 0;
			int add = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int height = land[i][j];

					if (height > h) {
						remove += (height - h);
					} else if (height < h) {
						add += (h - height);
					}
				}
			}

			if (remove + B >= add) {
				int time = remove * 2 + add;

				if (time < resultTime) {
					resultTime = time;
					resultHeight = h;
				} else if (time == resultTime && h > resultHeight) {
					resultHeight = h;
				}
			}
		}

		System.out.println(resultTime + " " + resultHeight);

	}

}
