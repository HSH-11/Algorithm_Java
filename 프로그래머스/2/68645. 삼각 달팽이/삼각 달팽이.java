class Solution {
    public int[] solution(int n) {
        // 아래 -> 오른쪽 -> 왼쪽 위 -> 아래
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};
        
        // 삼각형 배열
        int[][] triangle = new int[n][n];
        
        int r = 0;
        int c = 0;
        int dir = 0;
        
        int num = 1;
        
        while (true) {
            
            triangle[r][c] = num;
            
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            // 다음 위치가 범위를 벗어나거나 이미 채워진 경우면 방향 변경
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || triangle[nr][nc] != 0) {
                
                dir = (dir + 1) % 3;
                
                nr = r + dr[dir];
                nc = c + dc[dir];
                
                // 방향을 바꿔도 이미 채워진 경우거나 이탈이면 종료
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || triangle[nr][nc] != 0) {
                    break;
                }
            }
            
            num++;
            r = nr;
            c = nc;
 
        }
        
        // 결과 배열
        int[] answer = new int[n * (n + 1) / 2];

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}