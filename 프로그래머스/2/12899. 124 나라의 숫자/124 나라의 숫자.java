class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            // 124 나라에는 0이 없으므로 인덱스를 0부터 시작하도록 조정
            n--;
            
            int remainder = n % 3;
            
            if (remainder == 0) {
                answer.append("1");
            } else if (remainder == 1) {
                answer.append("2");
            } else {
                answer.append("4");
            }
            
            n /= 3;
        }
        
        return answer.reverse().toString();
        
    }
}