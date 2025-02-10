import java.util.ArrayDeque;
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        char[] arr = s.toCharArray();
		for (char c : arr) {
			if (c == '(') {
				stack.push(c);
					
			}else {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}
			
		}
        if (stack.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }
}