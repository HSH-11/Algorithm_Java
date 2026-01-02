import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1); // 처음 등장하면 -1을 주기 위함
        
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            answer[i] = lastPos[idx] == -1 ? -1 : i - lastPos[idx];
            lastPos[idx] = i;
        }
        
        return answer;
    }
}