import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[][] board;
	static int[][] dp;
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board =  new int[N+1][N+1];
		dp =  new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//누적합 계산
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++ ) {
				dp[i][j] = board[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]; 
			}
		}
		
		
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); 
			int y1 = Integer.parseInt(st.nextToken()); 
			int x2 = Integer.parseInt(st.nextToken()); 
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
			System.out.println(result);
			
		}
	
	}
	
	
}