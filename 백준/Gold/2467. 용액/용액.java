import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// N이 100,000까지니까 조합 방식으로는 시간초과
// 이분 탐색으로 진행해야 함
// 해결방법
// N개가 오름차순으로 정렬되어 있음
// 시작,끝 포인터를 이용해 합이 0보다 크면 오른쪽 포인터 왼쪽 이동
// 합이 0보다 작으면 왼쪽 포인터 오른쪽으로 이동
// 합이 0이면 즉시 종료
public class Main {

	static int N;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 용액 입력
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = N - 1;
		int minAbs = Integer.MAX_VALUE;
		int answerL = 0, answerR = 0;

		while (left < right) {
			int sum = nums[left] + nums[right];

			if (sum == 0) {
				System.out.println(nums[left] + " " + nums[right]);
				return;
			}

			if (Math.abs(sum) < minAbs) {
				minAbs = Math.abs(sum);
				answerL = nums[left];
				answerR = nums[right];
			}

			if (sum > 0) {
				right--;
			} else {
				left++;
			}

		}

		System.out.println(answerL + " " + answerR);
	}

}