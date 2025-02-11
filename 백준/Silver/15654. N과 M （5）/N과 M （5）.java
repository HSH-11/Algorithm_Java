import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		Backtrack(nums, 0);

	}

	static void Backtrack(int[] nums, int depth) {
		if (depth == M) {
			for (int num : arr)
				System.out.print(num + " ");
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = nums[i];		
				Backtrack(nums, depth + 1);
				visited[i] = false;
			}
		}
	}
}