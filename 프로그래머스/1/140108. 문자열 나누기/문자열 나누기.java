class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCount = 0;
        int diffCount = 0;
        char x = ' '; // 기준 문자
        
        for (int i = 0; i < s.length(); i++) {
            if (sameCount == 0) {
                answer++; // 새로운 덩어리 시작
                x = s.charAt(i);
                sameCount = 1;
                continue;
            }
            
            // 기준 문자와 비교
            if (s.charAt(i) == x) {
                sameCount++;
            } else {
              diffCount++;  
            }
            
            // 개수가 같아지면 카운트 초기화
            if (sameCount == diffCount) {
                sameCount = 0;
                diffCount = 0;
            }
        }
        
            
            
        return answer;
        } 
        
}