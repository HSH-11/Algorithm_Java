// 가중치 계산
class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] weights = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";
        
        for (int i = 0; i < word.length(); i++) {
            int index = vowels.indexOf(word.charAt(i));
            
            // (앞선 모음들이 건너뛴 개수) + 현재 글자 자체의 순서 1
            answer += (index * weights[i]) + 1;
        }
        
        return answer;
    }
}