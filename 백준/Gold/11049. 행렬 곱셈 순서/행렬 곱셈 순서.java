import java.io.*;
import java.util.*;

public class Main {

	static int[][] dp;
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		matrix = new int[N][2]; // 행,열 저장

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N][N]; // dp[i][j] : i번째 ~ j번째 행렬 곱의 최소 비용

		// 두 구간을 나눠서 각각 계산한 후 -> 그 두 결과 행렬을 곱하는 비용
		for (int len = 1; len < N; len++) {
			for (int i = 0; i + len < N; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;

				for (int k = i; k < j; k++) { // 자르는 위치
					// i부터 k까지 곱하는 최소 연산 수 (앞쪽 곱셈 연산 수)
					// k+1부터 j까지 곱하는 최소 연산 수 (뒤쪽 곱셈 연산 수)
					// 앞 결과 x 뒤 결과의 연산 비용
					int cost = dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
		}
		System.out.println(dp[0][N - 1]);
	}

}