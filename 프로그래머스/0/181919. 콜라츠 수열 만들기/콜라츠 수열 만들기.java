import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int n) {
       ArrayList<Integer> answer = new ArrayList<Integer>();
       while (true) {
            answer.add(n);
            if (n == 1) break;
            n = (n % 2 == 0) ? n/2 : 3 * n + 1;
       }
        return answer;
    }
}