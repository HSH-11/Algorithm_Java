import java.io.*;
import java.util.*;

// 문제 정의
// 각 학생은 자신이 선택한 단 한 명의 학생만을 가리킨다.
// 어느 팀에도 속하지 못한 학생 수를 구하라

// 문제 해결 전략
// 사이클을 이루는 학생들만 팀이 될 수 있다.
// DFS로 돌면서 싸이클이 형성되는 순간을 체크하고, 그에 포함된 학생들을 팀원으로 표시
// DFS 탐색이 끝나기 위해선 무조건 싸이클에 들어가야 함

// Pseudocode


public class Main {
	
	
	static int[] pick; // 각 학생이 선택한 다른 학생 번호
	static boolean[] visited;
	static boolean[] dfs; // 해당 노드에서 dfs가 끝났는지를 타나냄(=싸이클 처리 끝났는 지 여부)
	static int cnt;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			cnt = 0;
			pick = new int[n+1];
			visited = new boolean[n+1];
			dfs = new boolean[n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				pick[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
			System.out.println(n - cnt);
		}
		
	}
	
	static void dfs(int n) {
		// 이미 방문했으면, dfs 수행 중 다시 만난 것이므로 리턴
		// 이 경우는 재방문이지만, dfs이 true일 수도 false일 수도 있음
		if (visited[n]) return; 
		
		visited[n] = true;
		int next = pick[n];
		
		if (!visited[next]) { // 다음 학생을 아직 방문하지 않았으면 계속 dfs 진행
			dfs(next);
		}else if(!dfs[next]) { // 다음 학생을 방문하기는 했지만 아직 dfs가 끝나지 않았으면 => 싸이클 발생
			cnt++;
			//싸이클을 따라가면서 팀 있는 학생 수 증가
			for (int i = next; i != n; i = pick[i] ) {
				cnt++;
			}
		}
		
		dfs[n] = true; // 현재 노드에서 dfs 끝남 표시
	}

}
