import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int rows, cols;
    
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0,};
    
    public int[] solution(int m, int n, int[][] picture) {
        
        rows = picture.length;
        cols = picture[0].length;
        
        visited = new boolean[rows][cols];
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if (picture[i][j] == 0 || visited[i][j]) continue;
                
                // 같은 색으로 연결된 영역의 크기 탐색
                int size = bfs(picture, picture[i][j] , i, j);
                
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
            }
        }
        
        return new int[] {numberOfArea, maxSizeOfOneArea};
        
    }
    
    private int bfs (int[][] picture, int target, int r, int c) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        visited[r][c] = true;
        queue.offer(new int[]{r,c});
        
        int size = 1;
        
        while (!queue.isEmpty()) {
            
            int[] pos = queue.poll();
            
            int cy = pos[0];
            int cx = pos[1];
            
            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                                      
                // 배열 범위 이탈
                if (ny < 0 || ny >= rows || nx < 0 || nx >= cols) continue;
                // 다른 색이거나 이미 방문한 경우                
                if (visited[ny][nx] || picture[ny][nx] != target) continue;
                
                visited[ny][nx] = true;
                queue.offer(new int[] {ny, nx});
                
                size++;
            }
                    
        }
        
        return size;
              
    }
}