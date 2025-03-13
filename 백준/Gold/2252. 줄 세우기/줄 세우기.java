
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 선후관계가 있는 방향 비순환 그래프(뒤에서 다시 앞으로 오는 경우가 없음)
// 사이클이 없고 순서를 정하는 위상정렬 문제

// 문제 해결
// 위상정렬
// 진입 차수, 인접리스트, 큐 활용
// 모든 순서가 끝났는 데도 진입 차수가 0이 아닌 노드가 있다? 순환 존재
// 진입 차수가 0인 노드들을 찾아 큐에 넣기(가장 먼저 시작)
// 큐에서 노드를 하나 꺼낸 후 꺼낸 노드와 간선으로 연결된 노드들의 진입 차수 감소
// 진입 차수 배열 갱신 후 차수가 0인 것이 있다면 큐에 넣고 없으면 아무것도 안함
public class Main {

	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Integer>[] graph = new ArrayList[N + 1];
		int[] inDegree = new int[N + 1]; 
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			inDegree[B]++;
		}
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int start = queue.poll();
			sb.append(start).append(" ");
			
			for (int next : graph[start]) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		System.out.println(sb);
		
		
	}


}