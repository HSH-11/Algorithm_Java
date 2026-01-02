import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(score);
        
        // 뒤에서부터 m개씩 묶어서 계산
        for (int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m;
        }
        
        return answer;
    }
}