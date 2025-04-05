import java.io.*;
import java.util.*;

// 문제 조건
// 모든 도시의 쌍에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램

// 문제 해결
// 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구할 수 있는 플로이드 워셜 알고리즘 활용
// 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있으니 최소 비용인 버스 선택
// 각 도시마다 1부터N까지를 거쳐가는 최소 경로를 계산하는데 중간에 경로가 없는 부분은 제외해야한다.

public class Main {

	static int N, M;
	static int[][] city;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 수
		M = Integer.parseInt(br.readLine()); // 버스의 수
		
		city = new int[N+1][N+1];
		
		// 2차원 배열 무한대로 초기화
		for (int i = 1; i <= N; i++) {
			Arrays.fill(city[i], Integer.MAX_VALUE);
		}
		// 자기 자신으로 가는 비용 0으로 초기화
		for (int i = 1; i <= N; i++) {
			city[i][i] = 0;
		}
		// 버스 비용 입력받아 비용 초기화
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 시작 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 한 번 타는데 비용
			
			if (city[a][b] > c) {
				city[a][b] = c;
			}			
		}
		
		// 점화식에 따라 플로이드 워셜 알고리즘 수행
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// k를 거쳐 가는 경로가 존재해야 한다
					if (city[i][k] == Integer.MAX_VALUE || city[k][j] == Integer.MAX_VALUE) continue;
					city[i][j] = Math.min(city[i][j],city[i][k] + city[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (city[i][j] == Integer.MAX_VALUE) {
					sb.append("0").append(" ");
				}else {
					sb.append(city[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

	
}