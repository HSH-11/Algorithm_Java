import java.util.*;

class Solution {
    // 같은 칸이라고 어느 방향에서 들어왔느냐에 따라 다름 -> 방문한 칸/방향을 마주치면 이후 상황은 동일
    public int[] solution(String[] grid) {

        int R = grid.length;
        int C = grid[0].length();
        
        
        boolean[][][] visited = new boolean[R][C][4];
        
        List<Integer> result = new ArrayList<>();
        
        // 빛이 진행하는 방향
            // 0 = ↑
            // 1 = →
            // 2 = ↓
            // 3 = ←
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int dir = 0; dir < 4; dir++) {
                    
                    if (visited[r][c][dir]) {
                        continue;
                    }
                    int nr = r;
                    int nc = c;
                    int nd = dir;
                    int count = 0;
                    
                    // 경로 추적
                    while (!visited[nr][nc][nd]) {
                        
                        // 현재 상태 방문 처리
                        visited[nr][nc][nd] = true;
                        count++;
                        
                        // 현재 칸의 종류에 따라 방향 변경
                        char current = grid[nr].charAt(nc);
                        
                        // 방향 변경
                        // 음수 % 문제를 방지
                        if (current == 'L') {
                            nd = (nd + 3) % 4;
                        } else if (current == 'R') {
                            nd = (nd + 1) % 4;
                        } 
                        
                        // 다음 칸으로 이동
                        nr = (nr + dr[nd] + R) % R;
                        nc = (nc + dc[nd] + C) % C;
                    }
                    
                    result.add(count);
                }
            }
        }
        
        Collections.sort(result);

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
}