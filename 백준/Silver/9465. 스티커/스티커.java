import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M;
	static int[][] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[3][N+1];
			dp = new int[3][N+1];
			
			for (int j = 1; j <= 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[1][1] = arr[1][1];
			dp[2][1] = arr[2][1];
			
			if (N > 1) {
				dp[1][2] = arr[2][1] + arr[1][2];
				dp[2][2] = arr[1][1] + arr[2][2];
			}
			
			for (int k = 3; k <= N; k++) {
				// dp[1][k-2]에서 바로 dp[1][k]에서 오는 경우도 있지만 그건 절대 최대값이 될 수 없음
				// why? dp[2][k-1]을 건넜을 때보다 무조건 작은 값이기 때문에
				// 그리고 그 경우는 이미 dp[2][k-1]에 포함되어 있는 상황이다.
				dp[1][k] = arr[1][k] + Math.max(dp[2][k-1],dp[2][k-2]);
				dp[2][k] = arr[2][k] + Math.max(dp[1][k-1],dp[1][k-2]);
			}

			System.out.println(Math.max(dp[1][N], dp[2][N]));
			
		}
					

	}
}