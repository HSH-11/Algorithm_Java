import java.util.*;

class Solution {
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            answer[i] = isSafe(places[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean isSafe(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P' && !bfs(place, r, c)) {
                    return false;
                } 
            }
        }
        
        return true;
    }
    
    private boolean bfs (String[] place, int startR, int startC) {
        // 행,열,거리
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        
        queue.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            if (dist == 2) continue;
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                
                if (visited[nr][nc]) continue;
                
                char next = place[nr].charAt(nc);
                
                if (next == 'X') continue;
                
                if (next == 'P') return false;
                
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, dist + 1});
            }
        }
        
        return true;
    }
}