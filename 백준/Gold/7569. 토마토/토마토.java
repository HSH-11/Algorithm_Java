import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][][] tomatoes;
	static boolean[][][] visited;
	static int M, N, H;
	static Queue<Point> queue = new ArrayDeque<Main.Point>();

	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	static class Point {
		int z, y, x, days;

		public Point(int z, int y, int x, int days) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.days = days;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로(열)
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomatoes = new int[H][N][M];
		visited = new boolean[H][N][M];

		int totalTomatoes = 0;
		int ripeTomatoes = 0;

		for (int z = 0; z < H; z++) {
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					tomatoes[z][y][x] = Integer.parseInt(st.nextToken());

					if (tomatoes[z][y][x] == 1) {
						queue.add(new Point(z, y, x, 0));
						visited[z][y][x] = true;
						ripeTomatoes++;
					}
					if (tomatoes[z][y][x] != -1) {
						totalTomatoes++;
					}
				}
			}
		}

		// 모든 토마토가 익어있다면 0 출력 후 종료
		if (ripeTomatoes == totalTomatoes) {
			System.out.println(0);
			return;
		}

		int days = bfs();

		// BFS 이후 익지 않은 토마토가 있는지 확인
		for (int z = 0; z < H; z++) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (tomatoes[z][y][x] == 0) { // 익지 않은 토마토가 남아있다면
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(days);
	}

	static int bfs() {
		int maxDays = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int z = cur.z, y = cur.y, x = cur.x, days = cur.days;
			maxDays = Math.max(maxDays, days); 
// 			최소경로로 탐색하지만 BFS 탐색을 진행하면서 여러 개의 익은 토마토가 동시에 주변을 익혀 나감.
//			각 토마토가 익는 날짜(days)를 비교하면서 가장 늦게 익은 날짜를 저장해야 전체 걸린 일수를 알 수 있음.
			
			for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (tomatoes[nz][ny][nx] == 0 && !visited[nz][ny][nx]) {
                        tomatoes[nz][ny][nx] = 1; 
                        visited[nz][ny][nx] = true;
                        queue.add(new Point(nz, ny, nx, days + 1));
                    }
                }
            }

		}
		
		return maxDays;
	}
}