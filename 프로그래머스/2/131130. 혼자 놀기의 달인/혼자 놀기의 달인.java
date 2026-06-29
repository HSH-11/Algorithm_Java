import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int[] cards) {
        
        int N = cards.length;
        // 방문 배열
        visited = new boolean[N + 1];
        
        // 모든 카드 확인
        List<Integer> groups = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                groups.add(dfs(i, cards));
            }
        }
        
        // 그룹 크기 구하기
        Collections.sort(groups);
        
        int size = groups.size();
        
        if (size < 2) return 0;
        
        return groups.get(size - 1) * groups.get(size - 2);

    
    }
    
    private int dfs(int cur, int[] cards) {
        
        if (visited[cur]) {
            return 0;
        }
        
        visited[cur] = true;
        
        return 1 + dfs(cards[cur - 1], cards);
    }
}