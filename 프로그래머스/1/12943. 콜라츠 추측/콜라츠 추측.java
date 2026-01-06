class Solution {
    public int solution(int num) {
        // 오버플로우 방지를 위해 long 타입으로 변환
        long n = num;
        int answer = 0;
        
        while (n != 1) {
            // 500번을 시도해도 1이 되지 않으면 -1 반환
            if (answer >= 500) {
                return -1;
            }
            
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            
            answer++;
        }
        
        return answer;
    }
}