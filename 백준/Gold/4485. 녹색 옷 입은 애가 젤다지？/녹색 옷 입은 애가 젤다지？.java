import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static final int INF = Integer.MAX_VALUE;
	static int[][] map;
	static PriorityQueue<Node> pq;
	static int[][] dist;
	// 상,하,좌,우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int y;
		int x;
		int weight;

		public Node(int y,int x, int weight) {

			this.y = y;
			this.x = x;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				return;

			map = new int[N][N];
			dist = new int[N][N];

			// map 초기화
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
				}
			}

			dist[0][0] = map[0][0];

			dijkstra();
			
			cnt++;
			System.out.println("Problem "+cnt+": "+ dist[N-1][N-1]);

		}

	}

	static void dijkstra() {
		pq = new PriorityQueue<Node>();
		pq.offer(new Node(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int curr_y = node.y;
			int curr_x = node.x;
			int weight = node.weight;
			
			if (weight > dist[curr_y][curr_x]) continue;
			
			for (int i = 0; i < 4; i++) {
				int ny = curr_y + dy[i];
				int nx = curr_x + dx[i];
				
				if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
				
				if (dist[ny][nx] > dist[curr_y][curr_x] + map[ny][nx]) {
					dist[ny][nx] = dist[curr_y][curr_x] + map[ny][nx];
					pq.offer(new Node(ny,nx,dist[ny][nx]));
				}
			}
		}	
	}
}