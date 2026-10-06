import java.util.*;

class Solution {
    // i의 약수 중 자기 자신을 제외한 가장 큰 수 구하기
    public int[] solution(long begin, long end) {
        int length = (int)(end - begin) + 1;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            long pos = begin + i;
            if (pos == 1) {
                answer[i] = 0;
                continue;
            }
            answer[i] = getMaxDivisor(pos);
            
        }

        return answer;
    }
    
    private int getMaxDivisor(long n) {
        int maxDivisor = 1;
        
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                maxDivisor = (int) i; // 일단 작은 약수로 초기화
                if (n / i <= 10_000_000) {
                    return (int) (n / i);
                }
            }
        }
        
        return maxDivisor;
    }
}