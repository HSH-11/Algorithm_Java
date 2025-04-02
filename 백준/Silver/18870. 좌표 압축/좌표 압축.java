import java.io.*;
import java.util.*;

// 의사 코드
// 원본 클론
// 클론 배열 오름차순 정렬
// 원본의 값 lower bound로 인덱스 정의
public class Main {

	static int[] nums;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		lowerBound();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(nums[i]).append(" ");
		}
		System.out.println(sb);
	}

	static void lowerBound() {
		int[] sorted = nums.clone();
		Arrays.sort(sorted);

		// 중복 제거
		List<Integer> distinct = new ArrayList<Integer>();
		distinct.add(sorted[0]);

		for (int i = 1; i < sorted.length; i++) {
			if (sorted[i] != sorted[i - 1]) {
				distinct.add(sorted[i]);
			}
		}

		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = distinct.size();

			while (left < right) {
				int mid = (left + right) / 2;

				if (nums[i] > distinct.get(mid)) {
					left = mid + 1;
				} else {
					right = mid;
				}

			}
			nums[i] = left;

		}

	}

}
