class Solution {
    public String solution(String p) {
      
        return convert(p);
    }
    
    private String convert(String p) {
        
        // 빈 문자열
        if (p.isEmpty()) return "";
        
        // u, v로 분리
        int index = splitIndex(p);
        
        String u = p.substring(0, index);
        String v = p.substring(index);
        
        // u가 올바른 괄호 문자열이라면?
        if (isCorrect(u)) {
            return u + convert(v);
        }
        
        // u가 올바르지 않다면
        StringBuilder result = new StringBuilder();
        
        result.append("(");
        result.append(convert(v));
        result.append(")");
        
        // u의 첫번째와 마지막 괄호 제거 후 뒤집기
        for (int i = 1; i < u.length()-1; i++) {
            result.append(u.charAt(i) == '(' ? ')' : '(');
        }
        
        return result.toString();
    }
    
    // 가장 짧은 균형잡힌 문자열 u를 찾음
    private int splitIndex(String s) {

        int balance = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            // 처음으로 균형이 맞는 위치
            if (balance == 0) {
                return i + 1;
            }
        }

        return s.length();
    }
    
    // 올바른 괄호 문자열 판별
    private boolean isCorrect(String s) {
        
        int balance = 0;
        
        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
            } else {
                balance--;
            }

            // 닫는 괄호가 더 많아지는 순간 잘못된 문자열
            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}