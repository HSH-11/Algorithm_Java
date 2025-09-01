import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int MAX = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N));
	}

	static int bfs(int start) {
		int[] dist = new int[MAX + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(start);

		while (!dq.isEmpty()) {

			int cur = dq.poll();

			// 1) 순간이동 (가중치 0)
			int teleport = cur * 2;
			if (teleport <= MAX && dist[teleport] > dist[cur]) {
				dist[teleport] = dist[cur];
				dq.addFirst(teleport); // 앞에 넣음
			}

			// 2) 걷기 (가중치 1)
			int[] moves = { cur - 1, cur + 1 };
			for (int next : moves) {
				if (next >= 0 && next <= MAX && dist[next] > dist[cur] + 1) {
					dist[next] = dist[cur] + 1;
					dq.addLast(next); // 뒤에 넣음
				}
			}
		}
		return dist[K];

	}
}
