import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int num : arr) {
            for (int i = 0; i < num; i++) {
                answer.add(num);
            }
        }
        return answer;
    }
}