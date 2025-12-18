import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minKeys = new HashMap<>();
        
        // 모든 자판을 돌며 각 문자의 최소 타수 기록
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int count = i + 1;
                
                // 기존 값보다 작을 때만 갱신
                minKeys.merge(c, count, (oldValue, newValue) -> Math.min(oldValue, newValue));
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++){
            int total = 0;
            for (char c : targets[i].toCharArray()) {
                if (minKeys.containsKey(c)) {
                    total += minKeys.get(c);
                }else {
                    total = -1;
                    break;
                }
            }
            answer[i] = total;
        }
                                         
        return answer;
    }
}