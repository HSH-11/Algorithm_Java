import java.io.*;
import java.util.*;

public class Main {

	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		long count = 0;

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				int target = -(nums[i] + nums[j]);
				int lower = lowerBound(j + 1, N, target); // target보다 크거나 같은 첫 위치
				int upper = upperBound(j + 1, N, target); // target보다 큰 첫 위치
				count += (upper - lower);
			}
		}

		System.out.println(count);
	}

	static int lowerBound(int left, int right, int tgt) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < tgt) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		return left;
	}
	
	static int upperBound(int left, int right, int tgt) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] <= tgt) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		return left;
	}
}