import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
       // 1. 오늘 날짜를 일 단위로 변환
        int todayTotalDays = getTotalDays(today);
        
        // 2. 약관 정보를 Map에 저장
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]) * 28);
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            int startTotalDays = getTotalDays(p[0]);
            int expiryDays = startTotalDays + termMap.get(p[1]);
            
            // 오늘 >= 시작일 + 기간이면 파기
            if (todayTotalDays >= expiryDays) {
                answer.add(i+1);
            }
            
        }
        return answer;
    }
    
    // 날짜 문자열을 받아서 총 '일(days)'로 바꿔주는 메서드
    private int getTotalDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}