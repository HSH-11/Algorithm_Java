import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*<문제 분석>
 * N개를 두 개의 선거구로 나눠야 하며, 각 구역은 두 선거구 중 하나에 포함되어야 함
 * 선거구는 구역을 적어도 하나 포함해야 하며, 한 선거구에 포함되어 있는 구역은 모두 연결
 * 두 선거구의 인구 차이 최소
 * <의사 코드>
 * 부분집합->선거구 2개
 * 각 선거구 모두 연결? BFS,DFS
 * 모두 연결=> 인구수 계산 최소값
*/

public class Main {

	static int[] populations;
	static int N;
	static ArrayList<Integer>[] adjList;
	static int diff = Integer.MAX_VALUE;
	static boolean[] selected;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		populations = new int[N+1];
		
		//인구수
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for (int i = 1; i <= N; i++) {
			populations[i] = Integer.parseInt(st.nextToken());
		}
		
		//인접 리스트 초기화
		adjList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		//그래프 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				adjList[i].add(v);
			}
		}
		
		selected = new boolean[N+1];
		//부분집합 구하고
		subset(1);
		//bfs탐색해서 연결 되어 있는지 확인하면서 연결 최소값
		if (diff == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(diff);
		
		
	}
	
	static void subset(int idx) {
		if (idx > N) {
			List<Integer> A = new ArrayList<Integer>();
			List<Integer> B = new ArrayList<Integer>();
			
			//두 개의 선거구로 나누기
			for (int i = 1; i <= N; i++) {
				if (selected[i]) A.add(i);
				else B.add(i);
			}
			// 두 선거구가 모두 비어 있지 않고 연결되어 있는 지 확인
			if (!A.isEmpty() && !B.isEmpty() && bfs(A) && bfs(B)) {
				int sum_a = 0;
				int sum_b = 0;
				for (int a : A) {
					sum_a += populations[a];
				}
				for (int b : B) {
					sum_b += populations[b];
				}
				diff = Math.min(diff, Math.abs(sum_a-sum_b));
			}
			return;
		}
		
		//현재 구역 A에 추가
		selected[idx] = true;
		subset(idx + 1);
		
		//현재 구역 B에 추가
		selected[idx] = false;
		subset(idx + 1);
	}
	
	//그룹 내 지역들이 서로 연결되어 있는 지 확인
	static boolean bfs(List<Integer> group) {
		visited = new boolean[N+1];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(group.get(0));
		visited[group.get(0)] = true;
		
		int count = 1;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int next: adjList[node]) {
				// 그룹 내 임의의 한 노드들로 부터 인접한 노드가 그룹에 있는 지 방문 안했는 지 
				if(!visited[next] && group.contains(next)) {
					visited[next] = true;
					queue.offer(next);
					count++; 
				}
			}
		}
		
		return count == group.size(); // 모두 방문해야 연결
	}
	
}