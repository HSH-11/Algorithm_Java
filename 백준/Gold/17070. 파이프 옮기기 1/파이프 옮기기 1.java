import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*<문제 분석>
파이프는 회전 가능(총3방향)
-오른쪽,아래,오른쪽 대각선 방향
-가로(가로,대각선)
-세로(세로,대각선)
-대각(가로,세로,대각선)
-시작은 (1,1),(1,2) 가로 N,N으로 이동 시키는 방법
1.완탐 2.Dp
/*<의사코드>
 * 
 * 각 지점에 오는 경우의 수는 대각,위,왼쪽 
*/

public class Main {

	static int N;
	static int[][] map;
	static int[][][] dp;
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N][3];
		
		//맵 정보 입력
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][1][0] = 1; // 파이프는 처음 (0,1)에서 시작, 가로 방향으로 시작
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 1) continue;
				
				if (j-1 >= 0) {
					dp[i][j][0] += dp[i][j-1][0];
					dp[i][j][0] += dp[i][j-1][2];
				}
				
				if (i-1 >= 0) {
					dp[i][j][1] += dp[i-1][j][1];
					dp[i][j][1] += dp[i-1][j][2];
				}
				
				if (j-1 >=0 && i-1 >= 0 && map[i-1][j] == 0 && map[i][j-1] == 0) {
					dp[i][j][2] += dp[i-1][j-1][0];
					dp[i][j][2] += dp[i-1][j-1][1];
					dp[i][j][2] += dp[i-1][j-1][2];
				}
				
			}
		}
		
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
		
		
	}
	
}