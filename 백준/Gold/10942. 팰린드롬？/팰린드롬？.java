import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 매 쿼리마다 팰린드롬을 계산하면 시간초과
// 부분 수열의 팰린드롬을 미리 계산해두자
public class Main {

	static int[] nums;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		dp = new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 길이가 1이면 무조건 팰린드롬
		for (int i = 1; i <= N; i++) {
			dp[i][i] = 1;
		}
		
		// 길이가 2인 경우
		for (int i = 1; i < N; i++) {
			if (nums[i] == nums[i+1]) {
				dp[i][i+1] = 1;
			}
		}
		
		// 길이가 3 이상인 경우
		for (int len = 3; len <= N; len++) {
			for (int i = 1; i <= N - len + 1; i++) {
				int j = i + len -1; // 끝 인덱스
				if (nums[i] == nums[j] && dp[i+1][j-1] == 1) {
					dp[i][j] = 1;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(dp[S][E]).append("\n");
		}
		
		System.out.println(sb);
	}

}