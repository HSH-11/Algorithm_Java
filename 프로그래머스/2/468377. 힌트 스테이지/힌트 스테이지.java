class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int answer = Integer.MAX_VALUE;
        
        // 마지막 스테이지를 제외한 구매 조합 탐색
        // mask의 각 비트가 해당 스테이지의 번들 구매 여부를 나타냄
        // 구매 조합 수 2^(n-1)
        for (int mask = 0; mask < (1 << (n - 1)); mask++) {
            int[] hintCount = new int[n];
            int total = 0;
            
            // 1. 번들 구매 여부 결정
            for (int stage = 0; stage < n - 1; stage++) {
                if ((mask & (1 << stage)) != 0) {
                    // 번들 구매 비용
                    total += hint[stage][0];
                    
                    // 번들에 포함된 힌트권 수량 누적
                    for (int j = 1; j < hint[stage].length; j++) {
                        int target = hint[stage][j];
                        hintCount[target - 1]++;
                    }
                }
            }
            
            // 2. 각 스테이지 해결 비용 계산
            for (int stage = 0; stage < n; stage++) {
                int used = Math.min(hintCount[stage], n - 1);
                total += cost[stage][used];
            }
            
            // 3. 최소 비용 갱신
            answer = Math.min(answer, total);
            
        }
        
        return answer;
    }
}