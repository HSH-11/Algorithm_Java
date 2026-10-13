class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        
        while (true) {
            // 제거 대상 탐색
            boolean[][] remove = findTargets(map, m, n);
            
            // 제거 대상 유무
            boolean found = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        found = true;
                        break;
                    }
                }
                
                if (found) break;
            }
            
            // 제거 대상 없음
            if (!found) break;
            
            // 제거 및 개수 계산
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }
            
            // 보드 갱신
            gravity(map, m, n);
        }
        
        return answer;
    }
    
    // 2x2 블록을 탐색하고 제거 대상 칸을 boolean 배열에 기록
    private boolean[][] findTargets (char[][] map, int m, int n) {
        boolean[][] remove = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = map[i][j];

                if (c == '.') continue;

                if (map[i][j + 1] == c
                    && map[i + 1][j] == c
                    && map[i + 1][j + 1] == c) {

                    remove[i][j] = true;
                    remove[i][j + 1] = true;
                    remove[i + 1][j] = true;
                    remove[i + 1][j + 1] = true;
                }
            }
        }

        return remove;
    }
    
    private void gravity(char[][] map, int m, int n) {
        for (int j = 0; j < n; j++) {
            int empty = m - 1; // 블록이 내려갈 위치

            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] != '.') {
                    map[empty][j] = map[i][j];
                    empty--;
                }
            }

            // 남은 위쪽 칸은 빈칸으로 처리
            while (empty >= 0) {
                map[empty][j] = '.';
                empty--;
            }
        }
    }
}