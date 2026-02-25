import java.util.*;

class Solution {
    public long solution(int[] weights) {
        
        // 몸무게 오름차순 정렬
        // "나보다 큰 몸무게" 중에서 짝꿍을 찾도록 함 (중복 제거)
        Arrays.sort(weights);
        
        long answer = 0;
        long[] count = new long[1001];
        
        for (int w : weights) count[w]++;
        
        for (int i = 100; i <= 1000; i++) {
            if (count[i] == 0) continue;

            // 1:1 경우
            answer += (count[i] * (count[i] - 1)) / 2;

            // 2:3 비율
            if ((i * 3) % 2 == 0) {
                int target = (i * 3) / 2;
                if (target <= 1000) answer += count[i] * count[target];
            }

            // 2:4 비율
            if (i * 2 <= 1000) {
                int target = i * 2;
                answer += count[i] * count[target];
            }

            // 3:4 비율
            if ((i * 4) % 3 == 0) {
                int target = (i * 4) / 3;
                if (target <= 1000) answer += count[i] * count[target];
            }
        }
    
        return answer;
    }
}