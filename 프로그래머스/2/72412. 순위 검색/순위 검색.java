import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        // 지원자 정보 추출
        // 1. 지원자 한 명당 가능한 조건 조합 생성
        for (String candidate : info) {
            String[] profile = candidate.split(" ");
            
            int score = Integer.parseInt(profile[4]);
            
            for (int mask = 0; mask < 16; mask++) {
                StringBuilder key = new StringBuilder();
                
                for (int i = 0; i < 4; i++) {
                    if (i > 0) key.append(" ");
                    
                    if ((mask & (1 << i)) != 0) {
                        // 해당 비트가 1이면 -로 변경
                        key.append("-");
                    }else {
                        key.append(profile[i]);
                    }
                }
                // 조합 생성 후 점수 추가
                map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(score);
            }
        }
        
        // 2. 모든 점수 목록을 오름차순 정렬
        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }
        
        // 3. 각 쿼리 처리
        int[] answer = new int[query.length];
        
        for (int i = 0; i < query.length; i++) {
            String[] condition = query[i].split(" and ");
            
            String foodAndScore = condition[3];
            String[] last = foodAndScore.split(" ");
            
            String key = condition[0] + " "
                    + condition[1] + " "
                    + condition[2] + " "
                    + last[0];
            
            int targetScore = Integer.parseInt(last[1]);
            
            List<Integer> scores = map.get(key);
            
            if (scores == null) {
                answer[i] = 0;
                continue;
            }
            
            // 4. 기준 점수 이상인 첫 번째 위치 탐색
            int left = 0;
            int right = scores.size();
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                
                if (scores.get(mid) >= targetScore) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            
            // 전체 개수 - 기준 점수 이상인 첫 위치
            answer[i] = scores.size() - left;
            
        }
        
        return answer;
    }
}