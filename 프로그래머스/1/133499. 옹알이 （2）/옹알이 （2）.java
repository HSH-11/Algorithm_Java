class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] speaks = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
            // 연속된 발음이 있는지 확인
            boolean canSpeak = true;
            for (String s : speaks) {
                if (b.contains(s + s)) {
                    canSpeak = false;
                    break;
                }       
            }
            
            if (canSpeak) {
                // 발음 가능한 단어 공백으로 치환
                for (String s : speaks) {
                    b = b.replace(s," ");
                }
                
                // 모든 공백을 제거했을 때 빈 문자열이면 발음 가능
                if (b.trim().length() == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}