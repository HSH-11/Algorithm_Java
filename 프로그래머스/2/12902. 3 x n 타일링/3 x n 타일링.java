// 성능 개선 참고
// 누적합 사용하면 O(n)에 끝남
class Solution {
    public long solution(int n) {
        long mod = 1000000007;
        long[] dp = new long[n+1];
        
        dp[0] = 1;
        dp[2] = 3;
        
        long specialSum = 0;
        // dp[n] = (dp[n-2] * 3) + (dp[n-4] * 2) + (dp[n-6] * 2) + (dp[n-8] * 2) + ... + 2
        
        for (int i = 4; i <= n; i += 2) {
            specialSum = (specialSum + dp[i - 4]) % mod;
            
            dp[i] = (dp[i-2] * 3) % mod;
            dp[i] = (dp[i] + (specialSum * 2) % mod) % mod;
        }
        
        return dp[n];
    }
}