import java.io.*;
import java.util.*;

public class Main {

	static int N, S;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, false);

		System.out.println(answer);

	}

	static void dfs(int idx, int sum, boolean selected) {
		if (idx == N) {
			if (sum == S && selected) {
				answer++;
			}
			return;
		}

		// 현재 숫자 선택
		dfs(idx + 1, sum + arr[idx], true);
		// 현재 숫자 미선택
		dfs(idx + 1, sum, selected);
	}

}