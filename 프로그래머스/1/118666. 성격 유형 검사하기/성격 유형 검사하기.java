import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 성격 유형별 점수를 저장할 Map 초기화
        Map<Character, Integer> scoreMap = new HashMap<>();
        char[] types = {'R','T','C','F','J','M','A','N'};
        for (char t : types) scoreMap.put(t,0);
        
        // 점수 계산
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            
            if (choice > 4) { // 동의
                char type = survey[i].charAt(1);
                scoreMap.put(type, scoreMap.get(type) + (choice - 4));
            } else if (choice < 4) { // 비동의
                char type = survey[i].charAt(0);
                scoreMap.put(type, scoreMap.get(type) + (4 - choice));
            }
            
        }
        
        // 지표별로 점수 높은 유형
        StringBuilder answer = new StringBuilder();
        answer.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        answer.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        answer.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        answer.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');
        
        return answer.toString();
    }
}