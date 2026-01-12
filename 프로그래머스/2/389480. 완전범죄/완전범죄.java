import java.util.*;

// 둘 다 안잡히기 위해 B의 흔적을 가장 작게 유지해야함
// - B를 최대한 아껴서 안잡히게 만든 뒤, 안 잡히고 버틴 상태들 중에서 A의 흔적이 가장 작은 것 고르기
class Solution {
    public int solution(int[][] info, int n, int m) {
        // DP 배열 초기화 (A의 흔적을 인덱스로 사용, B도둑이 남긴 누적 흔적의 최솟값 저장)
        int[] dp = new int[n];
        int INF = 1000000;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // 모든 물건을 순회
        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];
            
            // 다음 상태를 담을 임시 배열
            int[] nextDp = new int[n];
            Arrays.fill(nextDp, INF);

            for (int j = 0; j < n; j++) {
                if (dp[j] == INF) continue;

                // Case 1: A도둑이 훔치는 경우
                if (j + aCost < n) {
                    nextDp[j + aCost] = Math.min(nextDp[j + aCost], dp[j]);
                }

                // Case 2: B도둑이 훔치는 경우
                if (dp[j] + bCost < m) {
                    nextDp[j] = Math.min(nextDp[j], dp[j] + bCost);
                }
            }
            // dp 배열 업데이트
            dp = nextDp;
        }

        // 모든 물건을 훔친 후, B의 흔적이 m 미만인 경우 중 가장 작은 A의 흔적(index) 찾기
        for (int j = 0; j < n; j++) {
            if (dp[j] < m) return j;
        }

        return -1;
    }
}