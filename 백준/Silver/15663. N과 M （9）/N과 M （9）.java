
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr, tgt;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		tgt = new int[M];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0);
		System.out.println(sb);

	}

	static void dfs(int depth) {
		// 기저조건
		if (depth == M) {
			for (int num : tgt) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// 중복 방지 (이전 값과 같고, 이전 값이 아직 방문하지 않았다면 continue
			if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) {
				continue;
			}

			visited[i] = true;
			tgt[depth] = arr[i];
			dfs(depth+1);
			visited[i] = false;
		}

	}
}