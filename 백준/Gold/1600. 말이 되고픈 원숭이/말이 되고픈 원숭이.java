import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/*<문제 분석>
 * -말은 X표시한 곳으로 갈 수 있음+장애물 뛰어 넘기 가능
 * 원숭이는 K번만 말처럼 이동할 수 있고 그 외에는 그냥 인접한 칸으로만 움직일 수 있음(대각선 제외)
 * 원숭이 시작 (0,0)에서 도착(N-1,M-1)
 * 원숭이가 최소한의 동작으로 도착지점에 가는 방법은? => BFS
 * 말의 이동 규칙 : L자(상하좌우 2칸 이동 후 옆으로 한 칸 이동)
 * 말의 이동 방식을 어떨 때 사용해야하는가...
 * <의사 코드>
 * BFS:
 * while 큐가 비어있지 않으면:
 * 		현재 위치 꺼내기
 * 		만약 현재 위치가 도착 지점이면 끝
 * 
 * 		일반 이동 (4방향):
 * 			보드 경계 체크+장애물 없고, 방문한 적 없음
 * 			-큐에 추가
 * 			-방문 처리
 * 		말 (K번만 가능):
 * 			K가 0이 아니라면:
 * 				가능한 말 이동 방향
 * 				보드 경계 체크+장애물 없고, 방문한 적 없음
 * 				-큐에 추가
 * 				-방문 처리
 * 				-K 감소
*/

public class Main {

	static int K,W,H;
	static int[][] board;
	static boolean[][][] visited;
	
	// 이동 방향
	static int[] dy = {-1,1,0,0,-2,-1,1,2,2,1,-1,-2};
	static int[] dx = {0,0,-1,1,1,2,2,1,-1,-2,-2,-1};
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st =  new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); //열
		H = Integer.parseInt(st.nextToken()); //행
		
		board = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		int result = bfs();
		System.out.println(result);
			
	}
	
	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {0,0,0,K}); // 이동 횟수,말 점프 가능 K
		visited[0][0][K] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cy =  curr[0];
			int cx =  curr[1];
			int move = curr[2];
			int k = curr[3];
			
			if (cy == H-1 && cx == W-1) return move;
			
			for (int i = 0; i < 12; i++) {
			
					int ny = cy + dy[i];
					int nx = cx + dx[i];
					
					int check_k = (i < 4) ? k : k-1;
					
					if (check_k < 0) continue;
					if (ny >= H || ny <0 || nx >= W || nx < 0) continue;
					if (visited[ny][nx][check_k] || board[ny][nx] == 1) continue;
					
					visited[ny][nx][check_k] = true;
					queue.offer(new int[] {ny,nx,move+1,check_k});
							
			}
						
		}
		return -1;			
	}
}