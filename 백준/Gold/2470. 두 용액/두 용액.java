import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 추가
        Arrays.sort(nums);

        int left = 0, right = N - 1;
        int minAbs = Integer.MAX_VALUE;
        int answerL = 0, answerR = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (Math.abs(sum) < minAbs) {
                minAbs = Math.abs(sum);
                answerL = nums[left];
                answerR = nums[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                // 합이 0이면 가장 이상적인 경우이므로 즉시 종료
                break;
            }
        }

        System.out.println(answerL + " " + answerR);
    }
}
