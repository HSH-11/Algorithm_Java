import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int e : enemy) {
            pq.add(e);
            n -= e;
            
            // 병사가 부족하면 무적권 쓰기
            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    n += pq.poll(); // 가장 적이 많았던 라운드의 병사를 복구
                    k--;
                }else {
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}