import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        // 이름 - 인덱스
        Map<String,Integer> idx = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            idx.put(friends[i], i);
        }
        
        // 선물 기록
        int[][] give = new int[n][n];
        
        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            int a = idx.get(st.nextToken()); //준 사람
            int b = idx.get(st.nextToken()); //받은 사람
            give[a][b]++;
        }
        
        // 각자 받고, 준 선물 개수 계산
        int[] totalGive = new int[n];
        int[] totalReceive = new int[n];
        
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                totalGive[a] += give[a][b];
                totalReceive[b] += give[a][b];
            }
        }
        
        // 선물 지수 계산
        int[] giftScore = new int[n];
        for (int i = 0; i < n; i++){
            giftScore[i] = totalGive[i] - totalReceive[i];
        }
        
        // 다음 달 받을 선물 개수 계산
        int[] next = new int[n];
        
        for (int a = 0; a < n; a++){
            for (int b = a + 1; b < n; b++) {
                
                int ab = give[a][b];
                int ba = give[b][a];
                
                if (ab > ba) {
                    next[a]++;
                }else if (ba > ab) {
                    next[b]++;
                } else {
                    if (giftScore[a] > giftScore[b]) {
                        next[a]++;
                    }else if (giftScore[b] > giftScore[a]){
                        next[b]++;
                    }
                    // 선물 지수도 같으면 선물 주고 받지 않음
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++){
            answer = Math.max(next[i],answer);
        }
        return answer;
    }
}