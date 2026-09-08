// BFS → 좌표로 모양 저장 → 회전 → 위치 정규화 → 좌표 정렬 → 같은 모양인지 비교
import java.util.*;

class Solution {
    
    // 상하좌우
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n = table.length;
        boolean[][] visited = new boolean[n][n];
        
        // 1. table에서 퍼즐 조각 찾기
        List<List<int[]>> shapes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (table[i][j] == 0 || visited[i][j]) continue;
                
                List<int[]> shape = bfs(table, i, j, visited, 1);
                
                // 정규화
                shape = normalize(shape);
                
                // 좌표정렬
                sortShape(shape);
                
                shapes.add(shape);
            
            }
        }
        
        // 2. game_board에서 빈 공간 추출
        boolean[][] visitedBoard = new boolean[n][n];
        List<List<int[]>> spaces = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (game_board[i][j] == 1 || visitedBoard[i][j]) {
                    continue;
                }

                List<int[]> space = bfs(game_board, i, j, visitedBoard, 0);

                space = normalize(space);
                sortShape(space);

                spaces.add(space);
            }
        }
        
        // 3. 퍼즐 조각과 빈 공간 비교
        boolean[] used = new boolean[shapes.size()];

        for (List<int[]> space : spaces) {

            for (int i = 0; i < shapes.size(); i++) {

                // 이미 사용한 퍼즐 조각
                if (used[i]) {
                    continue;
                }

                List<int[]> shape = shapes.get(i);

                // 크기가 다르면 비교할 필요 없음 (퍼즐을 구성하는 칸의 개수)
                if (space.size() != shape.size()) {
                    continue;
                }

                // 현재 모양
                if (sameShape(space, shape)) {
                    used[i] = true;
                    answer += shape.size();
                    break;
                }

                // 90도씩 회전하며 비교
                List<int[]> rotated = shape;

                for (int r = 0; r < 3; r++) {
                    rotated = rotate90(rotated);
                    sortShape(rotated);

                    if (sameShape(space, rotated)) {
                        used[i] = true;
                        answer += shape.size();
                        break;
                    }
                }

                // 현재 퍼즐 조각이 사용되었으면 다음 공간으로
                if (used[i]) {
                    break;
                }
            }
        }
        
        
        return answer;
    }
    
    // BFS로 하나의 퍼즐 조각 추출
    private List<int[]> bfs(int[][] table, int startR, int startC, boolean[][] visited, int target) {
        int n = table.length;
        
        List<int[]> shape = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {startR, startC});
        visited[startR][startC] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int r = current[0];
            int c = current[1];
            
            // 시작점을 기준으로 상대 좌표 저장
            shape.add(new int[]{r - startR, c - startC});
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc] || table[nr][nc] != target ) continue;
                
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
        
        return shape;
    }
    
    // 90도 시계 방향 회전 후 정규화 (해결 못 한 부분)
    private List<int[]> rotate90(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        
        for (int[] point : shape) {
            int r = point[0];
            int c = point[1];
            
            rotated.add(new int[]{c, -r});
        }
        
        return normalize(rotated);
    }
    
    // 좌표를 (0, 0)을 기준으로 정규화
    private List<int[]> normalize(List<int[]> shape) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        // 가장 작은 행, 열 찾기
        for (int[] point : shape) {
            minR = Math.min(minR, point[0]);
            minC = Math.min(minC, point[1]);
        }
        
        List<int[]> normalized = new ArrayList<>();

        // 최소값을 빼서 (0,0) 기준으로 이동
        for (int[] point : shape) {
            normalized.add(new int[]{
                point[0] - minR,
                point[1] - minC
            });
        }
    
        return normalized;
    }
    
    // 행 -> 열 순서로 좌표 정렬
    private void sortShape(List<int[]> shape) {
        shape.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            
            return Integer.compare(a[0], b[0]);
        });
    }
    
    // 두 도형의 좌표가 같은지 비교
    private boolean sameShape(List<int[]> a, List<int[]> b ) {
        
        if (a.size() != b.size()) {
            return false;
        }

        for (int i = 0; i < a.size(); i++) {
            int[] pointA = a.get(i);
            int[] pointB = b.get(i);

            if (pointA[0] != pointB[0] || pointA[1] != pointB[1]) {
                return false;
            }
        }

        return true;
    }
}