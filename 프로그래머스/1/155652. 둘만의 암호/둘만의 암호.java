import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        // 1. skip해야 할 문자를 제외한 순수 알파벳 리스트 만들기
        List<Character> filteredAlphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!skip.contains(String.valueOf(c))) {
                filteredAlphabet.add(c);
            }
        }
        
        // 2. s의 각 문자에 대해 index만큼 이동
        for (char c : s.toCharArray()) {
            int currentPos = filteredAlphabet.indexOf(c);
            // 리스트의 크기로 나머지 연산을 하면 자동으로 순환됨
            int nextPos = (currentPos + index) % filteredAlphabet.size();
            answer.append(filteredAlphabet.get(nextPos));
        }
        
        return answer.toString();
    }
}
