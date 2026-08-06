import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // 현재 숫자보다 뒤에 더 큰 숫자가 오면, 잎의 작은 숫자를 제거하는게 항상 이득
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : number.toCharArray()) {
            
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        // 아직 제거 횟수가 남아있으면 뒤에서부터 제거 (내림차순인 경우) 
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}