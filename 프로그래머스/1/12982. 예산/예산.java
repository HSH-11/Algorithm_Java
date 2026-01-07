import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for (int cost : d) {
            if (budget < cost) break; // 남은 예산보다 요구 금액이 크면 종료

            budget -= cost;
            answer++;
        }
        return answer;
    }
}