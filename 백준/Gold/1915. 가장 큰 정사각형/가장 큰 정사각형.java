import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

	static int N,M,length;
	
	static int[][] dp;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
		dp = new int[N+1][M+1];
		map = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j-1)-'0';
			}
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {			
				if (map[i][j] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
					length = Math.max(length, dp[i][j]);
				}
			}
		}
		
		System.out.println(length * length);
		
		
	}

}
