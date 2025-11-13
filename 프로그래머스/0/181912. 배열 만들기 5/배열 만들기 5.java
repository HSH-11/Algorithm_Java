import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String str : intStrs) {
            String sub = str.substring(s,s+l);
            
            if (Integer.parseInt(sub) > k) {
                answer.add(Integer.parseInt(sub));
            }
            
        }
        
        return answer;
    }
}