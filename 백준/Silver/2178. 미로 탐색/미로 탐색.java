import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static final int[] dx = { -1, 1, 0, 0 };
	private static final int[] dy = { 0, 0, -1, 1 };
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		

		System.out.println(bfs(N, M));

	}

	static int bfs(int N , int M) {
		
		Queue<int []> queue = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			
			if (x == N-1 && y == M-1) {
				return map[x][y];
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx>= 0 && ny>=0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
					queue.offer(new int[] {nx,ny});
				}
			}
		}
		return -1;
	}
}