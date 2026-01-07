import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int i = 0;
        
        // Pattern과 Matcher를 사용한 파싱
        Pattern pattern = Pattern.compile("(\\d+)([SDT])([*#]?)");
        Matcher mapper = pattern.matcher(dartResult);
        
        while(mapper.find()) {
            int n = Integer.parseInt(mapper.group(1)); // 점수
            String bonus = mapper.group(2); // 보너스
            String option = mapper.group(3); // 옵션
            
            // 그룹별 로직
            
            score[i] = (int) Math.pow(n, bonus.equals("S") ? 1 : bonus.equals("D") ? 2 : 3);
            
            if (option.equals("*")) {
                score[i] *= 2;
                if (i > 0) score[i-1] *= 2;
            } else if (option.equals("#")) {
                score[i] *= -1;
            }
            i++;
        }
        
        return score[0]+score[1]+score[2];
    }
}