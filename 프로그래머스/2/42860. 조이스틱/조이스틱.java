import java.util.*;
class Solution {
    public int solution(String name) {
        int cnt = 0;
              
        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            cnt += Math.min('Z'- name.charAt(i) + 1, name.charAt(i) - 'A');
            int next = i + 1;
            
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i * 2 + (name.length() - next));
            move = Math.min(move, (name.length() - next) * 2 + i);
        }
        
        return cnt + move;
    }
}