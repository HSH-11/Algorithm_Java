import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // 크기별로 개수 세기
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t,0) + 1);
        }
        
        // 개수만 모아서 리스트 생성
        List<Integer> counts = new ArrayList<>(map.values());
        
        // 정렬
        Collections.sort(counts);
        
        int answer = 0;
        
        // 뒤에서부터 k개 채우기
        for (int i = counts.size() - 1; i >= 0; i--) {
            k -= counts.get(i);
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}