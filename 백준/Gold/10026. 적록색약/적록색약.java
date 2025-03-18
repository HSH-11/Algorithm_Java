import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main {

	static int N;
	static char grid[][];
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean visited[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];

		for (int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][N];
		int normal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i,j,false);
					normal++;
				}
			}
		}
		
		visited = new boolean[N][N];
		int colorBlind = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i,j,true);
					colorBlind++;
				}
			}
		}
		
		System.out.println(normal+" "+colorBlind);
		
	}
	
	static void bfs(int y, int x, boolean isColorBlind) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {y,x});
		visited[y][x] = true;
		char color = grid[y][x];
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cy = cur[0];
			int cx = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
					
					if (isColorBlind) {
						if ((color == 'R' || color == 'G' ) && (grid[ny][nx] == 'R' || grid[ny][nx] == 'G')) {
							visited[ny][nx] = true;
							queue.add(new int[] {ny,nx});
						}else if( color == 'B' && grid[ny][nx] == 'B') {
							visited[ny][nx] = true;
							queue.add(new int[] {ny,nx});
						}
					}
					else {
						if (grid[ny][nx] == color) {
							visited[ny][nx] = true;
							queue.add(new int[] {ny,nx});
						}
					}
				}
			}
		}
	}

}