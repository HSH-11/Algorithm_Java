import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {
	
	static boolean[][] visited;
	static int[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int K;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		map = new int[K][K];
		visited = new boolean[K][K];
		for(int i = 0; i<K; i++) {
			String line = br.readLine();
			for (int j = 0; j<K; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					result.add(bfs(i,j));
				}
			}
		}
		System.out.println(result.size());
		
		Collections.sort(result);
		for (int s : result) {
			System.out.println(s);
		}
		
	}
	static int bfs (int y, int x) {
		Deque<int[]> queue = new ArrayDeque<int[]>();
		visited[y][x] = true;
		queue.add(new int[] {y,x});
		int count = 1;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int curr_y = curr[0];
			int curr_x = curr[1];
			for (int i = 0; i < 4; i++) {
				int ny = curr_y + dy[i];
				int nx = curr_x + dx[i];
				
				if (ny < 0 || ny >= K || nx < 0 || nx >= K || visited[ny][nx] || map[ny][nx] == 0) continue;
				
				count++;
				queue.add(new int[] {ny,nx});
				visited[ny][nx] = true;
			}
		}
		
		return count;
	}

}