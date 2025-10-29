import java.io.*;
import java.util.*;

public class Main {
	
	// 상,하,좌,우,왼위,오위,왼아,오아
	static int[] dy = {-1,1,0,0,-1,-1,1,1};
	static int[] dx = {0,0,-1,1,-1,1,-1,1};
	static boolean[][] visited;
	static int[][] map;
	static int land;
	static int C,R;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			if ( C == 0 && R == 0) break;
			
			map = new int[R][C];
			land = 0;
			
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[R][C];
			// bfs로 섬 탐사
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] == 1 && !visited[r][c]) {
						bfs(r, c);
						land++;
					}
				}
			}
			
			System.out.println(land);
			
		}
	}
	
	static void bfs(int r, int c) {
		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int y  = pos[0];
			int x = pos[1];
			
			for (int d = 0; d < 8; d++) {
				int curY = dy[d] + y;
				int curX = dx[d] + x;
				
				if (curY < 0 || curY >= R || curX < 0 || curX >= C) continue;

				if (map[curY][curX] == 1 && !visited[curY][curX]) {
					queue.add(new int[] {curY, curX});
					visited[curY][curX] = true;
				}
			}
		}
		
		
	}
}
