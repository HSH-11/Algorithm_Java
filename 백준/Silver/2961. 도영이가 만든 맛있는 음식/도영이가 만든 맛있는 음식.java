import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] ingredients;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ingredients = new int[N][2]; // [신맛, 쓴맛]

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			ingredients[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		
		// 비트마스크를 이용한 부분집합 탐색(1~ (1 << N)-1)
		for (int mask = 1; mask< (1 << N); mask++) {
			int S = 1;
			int B = 0;
			
			for (int i=0; i < N; i++) {
				if ((mask & (1 << i)) != 0) {
					S *= ingredients[i][0];
					B += ingredients[i][1];
				}
			}
			minDiff = Math.min(minDiff,Math.abs(S-B));
		}
		
		System.out.println(minDiff);

	}

}
