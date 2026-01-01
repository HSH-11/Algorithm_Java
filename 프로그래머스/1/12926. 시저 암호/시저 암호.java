class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                continue;
            }
            
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            
            // (현재 문자 - 기준점 + 이동거리) % 26 + 기준점
            char shifted = (char) ((c - base + n) % 26 + base);
            answer.append(shifted);            
        }

        
        return answer.toString();
    }
}