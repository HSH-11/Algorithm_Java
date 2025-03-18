import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//'ㅗ'자 모양을 제외하고는 깊이가 4인 DFS로 탐색이 가능 => 레전드네
//DFS는 보통 한 방향으로 이동하며 탐색하지만,'ㅗ'모양은 탐색 시 2번째 칸일 때 
//3번째 탐색을 시작하는 위치를 2번째 칸에서 다시 한번 탐색하도록 해야함
public class Main {

	static int N, M, max;
	static int[][] board;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, board[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(max);

	}

	static void dfs(int y, int x, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx])
				continue;

			if (depth == 2) {
				visited[ny][nx] = true;
				dfs(y, x, depth + 1, sum + board[ny][nx]);
				visited[ny][nx] = false;
			}

			visited[ny][nx] = true;
			dfs(ny, nx, depth + 1, sum + board[ny][nx]);
			visited[ny][nx] = false;
		}
	}

}