class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 배달과 수거의 남은 용량 각각 관리
        int d = 0;
        int p = 0;
        
        // 가장 먼 집부터 0번 집 방향으로 탐색
        for (int i = n - 1; i >= 0; i--) {
            
            // 현재 집의 물량 
            d -= deliveries[i];
            p -= pickups[i];
            
            // 배달 또는 수거 물량이 남아 있다면 왕복
            while (d < 0 || p < 0) {
                d += cap;
                p += cap;
                
                answer += (i + 1) * 2L;
            }
        }
        

        return answer;
    }
}