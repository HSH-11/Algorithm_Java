class Solution {
    public int solution(int n) {
        // 1부터 n까지 포함해야 하므로 크기는 n+1
        boolean[] isPrime = new boolean[n + 1];
        
        // 처음에는 모두 소수라고 가정
        for (int i = 2; i <= n; i++) isPrime[i] = true;
        
        // 에라토스테네스의 체 실행
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // i의 배수들 모두 false로 변경
                for (int j = i * i; j <= n; j+= i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) answer++;
        }
        return answer;
    }
}