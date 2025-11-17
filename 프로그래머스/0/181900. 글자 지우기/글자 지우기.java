import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] tmp = my_string.split("");
        
        for (int i : indices) {
            tmp[i] = "";
        }
        for (String x : tmp) {
            answer += x;
        }
        return answer;
    }
}