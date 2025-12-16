import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        // 1. 순위 인덱스 Map 초기화
        // 선수 이름, 현재 순위 인덱스 
        Map<String, Integer> rankMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        // 2. calling 순회하며 순위 변경
        for (String caller : callings) {
            int currentRank = rankMap.get(caller);
            
            int previousRank = currentRank - 1;
            String previousPlayer = players[previousRank];
            
            // 순위 교환
            players[currentRank] = previousPlayer;
            players[previousRank] = caller;
            
            // rankMap 업데이트
            
            rankMap.put(caller, previousRank);
            rankMap.put(previousPlayer, currentRank);
            
        }
        return players;
    }
}