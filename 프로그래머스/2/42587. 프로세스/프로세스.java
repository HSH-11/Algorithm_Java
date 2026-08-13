import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        // {프로세스 우선 순위, 원래 위치}
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i],i});
        }
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            
            boolean hasHigher = false;
            
            // 현재 프로세스보다 우선순위가 높은게 있는지 확인
            for (int[] process : queue) {
                if (process[0] > current[0]) {
                    hasHigher = true;
                    break;
                }
            }
            
            if (hasHigher) {
                // 뒤로 보냄
                queue.offer(current);
            } else {
                // 실행
                answer++;
                
                if (current[1] == location) {
                    return answer;
                }
            }
                     
        }
        
        return answer;
    }
}