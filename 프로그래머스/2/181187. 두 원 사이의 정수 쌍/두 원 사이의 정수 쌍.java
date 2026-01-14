class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // x축을 1부터 r2까지 순회
        for (int x = 1; x <= r2; x++) {
            // 큰 원 안에서의 최대 y값
            long yMax = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x,2)));
            
            // 작은 원 안에서의 최소 y값
            long yMin = 0;
            if (x < r1) {
                yMin = (long) Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(x,2)));
            }
                        
            answer += (yMax - yMin + 1);
            
        }
        return answer * 4;
    }
}