import java.io.*;
import java.util.*;

// 문제 조건
// 게임의 크기는 정해짐 (10 * 10)
// 보드판에는 1부터 100까지의 수가 하나씩 순서대로 적힘
// 도착한 칸이 사다리면, 사다리를 타고 위로 올라간다.(사다리로 이동한 칸의 번호 > 원래 있던 칸 번호)
// 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다.
// 1번칸에서 시작해서 100번 칸에 도착하는 데 100번 칸에 도착하기 위해 주사위를 굴려야하는 최솟값을 구해야한다.

// 문제 해결
// BFS 방식
// 사다리와 뱀 위치를 Map으로 저장한다.
// 주사위를 굴리면서 100을 넘어가는 경우는 큐에서 제외
// 현재 위치를 기준으로 주사위를 굴려 다음에 이동할 위치에 사다리 혹은 뱀이 있는 경우는 이동 위치 새로 갱신 

public class Main {

	static int N, M;
	static HashMap<Integer, Integer> ladder_snake;
	static final int DICE = 6;
	static int Max = 100;
	static int[] dist = new int[Max + 1]; // 이동 횟수를 저장함
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 사다리 수
		M = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		// 사다리 뱀 위치
		ladder_snake = new HashMap<Integer, Integer>();
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			ladder_snake.put(curr, next);
		}

		bfs();

		System.out.println(dist[Max]);
	}

	static void bfs() {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		dist[1] = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= DICE; i++) {
				int next = cur + i;
				if (next > Max)
					continue;
				
				next = ladder_snake.getOrDefault(next, next);
				
				if (dist[next] == 0 && next != 1) { // 방문 안 했으면
					dist[next] = dist[cur] + 1;
					queue.add(next);
				}

			}
		}
	}
}