class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long x = 0; x <= d; x += k) {
            long maxYSquared = (long)d * d - x * x;
            int maxY = (int) Math.sqrt(maxYSquared);
            
            // y좌표가 0부터 maxY까지 k 간격으로 몇 개 있는지 계산
            answer += (maxY / k) + 1;
        }
        
        return answer;
    }
}