import java.io.*;
import java.util.*;

public class Main {
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (paper[i][j] == 1 && !visited[i][j]) {
					count++;
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
					
	}
	
	static int bfs(int s, int e) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {s,e});
		visited[s][e] = true;
		
		int area = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {			
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					
					if (nx >=0 && nx < N && ny >= 0 && ny < M) {
						if (!visited[nx][ny] && paper[nx][ny] == 1) {
							visited[nx][ny] = true;
							area++;
							queue.add(new int[] {nx,ny});
						}
					}
					
				
			}
		}
		return area;
	}

}