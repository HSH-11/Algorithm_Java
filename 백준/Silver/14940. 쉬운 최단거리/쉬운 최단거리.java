import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map,dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
			
		int start_x = -1;
		int start_y = -1;
		
		map = new int[n][m];
		dist = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1;
				if (map[i][j] == 2) {
					start_x = i;
					start_y = j;
				}
			}
		}
		bfs(start_x,start_y);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					sb.append(0).append(" ");
				}
				else {
					sb.append(dist[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
	}
	
	public static void bfs(int x, int y) {
		Deque<int []> queue = new ArrayDeque<>();
		queue.offer(new int[] {x,y});
		dist[x][y] = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (0<=nx && nx < n && ny >=0 && ny < m && map[nx][ny] != 0 && dist[nx][ny] == -1) {
					queue.offer(new int[] {nx,ny});
					dist[nx][ny] = dist[cx][cy] + 1;
				}
			}
		}
		
	}
}