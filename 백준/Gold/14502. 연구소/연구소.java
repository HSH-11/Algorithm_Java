import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*<문제 분석>
 * 바이러스가 상하좌우로 인접한 빈칸으로 퍼지는 걸 막아야 함
 * 새로 세울 수 있는 벽의 개수는 3개이며 꼭 세워야 함
 * BFS로 바이러스 퍼지는 거 
 * 브루트포스 방식으로 벽을 3개 세울 위치 선택하고 바이러스 퍼진 뒤 안전영역 크기의 최댓값 구하기
 * <해결 방법>
 * 빈 칸 중 벽을 3개 세울 위치를 조합으로 선택
 * 그리고 BFS로 돌려보기
 * 돌리고 남은 안전 영역 크기 구하면서 최대값 갱신
 * <의사 코드>
 * BFS:바이러스 위치에서 시작
 * while 큐가 비어있지 않으면:
 * 		현재 위치 꺼내기
 * 		일반 이동 (4방향):
 * 			보드 경계 체크+벽 없고, 방문한 적 없음
 * 			-큐에 추가
 * 			-방문 처리
 * 
 * 벽 세울 위치 조합 구하기
 * 	벽 세우고 바이러스 전파
 * 	bfs로 바이러스 퍼뜨리고 안전영역 계산
*/

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] simul;
	static boolean[][] visited;
	static int safe_max = 0;

	// 이동 방향
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static Queue<int[]> virus = new ArrayDeque<int[]>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		simul =  new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					//처음 바이러스 위치
					virus.offer(new int[] { i, j });
				}
			}
		}
		
		//벽 세우기
		wall(0, 0);
		
		System.out.println(safe_max);

	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		visited = new boolean[N][M];
		for (int[] v: virus) {
			queue.offer(v);
			visited[v[0]][v[1]] = true;
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cy = curr[0];
			int cx = curr[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				
				
				if (ny < 0 || ny >= N || nx <0 || nx >= M || visited[ny][nx] || simul[ny][nx] != 0) continue;
				
				visited[ny][nx] = true;
				simul[ny][nx] = 2;
				queue.offer(new int[] {ny,nx});
			
			}

		}

	}

	static void wall(int cnt, int start) {

		if (cnt == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					simul[i][j] = map[i][j];
				}
			}
			
			bfs();
			
			int area = 0;
			for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (simul[i][j] == 0) {
	                    area++;
	                }
	            }
	        }
			safe_max = Math.max(safe_max, area);	
			return;
		}
		
		for (int i = start; i < N * M; i++) {
			int r = i / M;
			int c = i % M;
			
			if (map[r][c] == 0) {
				map[r][c] = 1;
				wall(cnt+1,i+1);//다음 벽을 세울 위치로
				map[r][c] = 0;
			}
		}
	}
}