import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        
        for (int box = 1; box <= order.length; box++) {
            
            if (box == order[idx]) { // 지금 필요한 상자면 바로 트럭
                answer++;
                idx++;
            } else { // 아니면 보조 컨테이터
                stack.push(box);
            }
            
            
            while (!stack.isEmpty() && idx < order.length && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            }
        }
        return answer;
    }
}