class Solution {
    // i번째 행에서 j번째 열을 선택했을 때, 지금까지 얻을 수 있는 최대 점수
    int solution(int[][] land) {
        
        int N = land.length;
        int[][] dp = new int[N][4];
        
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                
                int max = 0;
                
                for (int k = 0; k < 4; k++) {
                    
                    if (k == j) continue;
                     
                    max = Math.max(max, land[i][j] + dp[i-1][k]);
                }
                
                dp[i][j] = max;
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[N-1][i]);
        }
        
        return answer;
    }
}