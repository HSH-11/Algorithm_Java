import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Deque<String> cards1_q = new ArrayDeque<String>(Arrays.asList(cards1)); 
        Deque<String> cards2_q = new ArrayDeque<String>(Arrays.asList(cards2)); 
        Deque<String> goal_q = new ArrayDeque<String>(Arrays.asList(goal));
        
        while (!goal_q.isEmpty()) {
        	String word = goal_q.peekFirst();
        	if (!cards1_q.isEmpty() && word.equals(cards1_q.peekFirst())) {
        		cards1_q.pollFirst();
        		goal_q.pollFirst();
        	}
        	else if(!cards2_q.isEmpty() && word.equals(cards2_q.peekFirst())) {
        		cards2_q.pollFirst();
        		goal_q.pollFirst();
        	}else {
        		answer = "No";
        		return answer;
        	}
        }
        answer = "Yes";
        return answer;
    }
}