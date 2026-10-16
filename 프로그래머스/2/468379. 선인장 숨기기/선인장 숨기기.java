import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        
        // 각 칸에 처음 비가 내리는 시점
        int[][] rain = new int[m][n];
        int neverRain = drops.length + 1;
        
        for (int[] row : rain) {
            Arrays.fill(row, neverRain);
        }
        
        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            rain[r][c] = i + 1;
        }
        
        // 세로 길이 h인 구간의 최솟값
        // 큐의 맨 앞이 현재 윈도우의 최솟값
        int[][] verticalMin = new int[m-h+1][n];
        
        for (int c = 0; c < n; c++) {
            Deque<Integer> deque = new ArrayDeque<>();
            
            for (int r = 0; r < m; r++) {
                
                // 현재 값보다 크거나 같은 값은 덱 뒤에서 인덱스 제거
                while (!deque.isEmpty() && rain[deque.peekLast()][c] >= rain[r][c]) {
                    deque.pollLast();
                }
                
                deque.offerLast(r);
                
                // 윈도우 범위를 벗어난 인덱스 제거
                while (!deque.isEmpty() && deque.peekFirst() <= r - h) {
                    deque.pollFirst();
                }
                
                // 세로 윈도우가 완성되면 최솟값 저장
                if (r >= h - 1) {
                    verticalMin[r - h + 1][c] = rain[deque.peekFirst()][c];
                }
            }
        }
        
        // 가로 길이 w인 구간의 최솟값
        int bestTime = -1;
        int bestRow = 0;
        int bestCol = 0;
        
        for (int r = 0; r <= m - h; r++) {
            Deque<Integer> deque = new ArrayDeque<>();
            
            for (int c = 0; c < n; c++) {
                
                while(!deque.isEmpty() && verticalMin[r][deque.peekLast()] >= verticalMin[r][c]) {
                    deque.pollLast();
                }
                
                deque.offerLast(c);
                
                while (!deque.isEmpty()
                        && deque.peekFirst() <= c - w) {
                    deque.pollFirst();
                }
                
                if (c >= w - 1) {
                    int currentTime = verticalMin[r][deque.peekFirst()];
                    
                    // 더 늦게 비를 맞는 구역 갱신하고 동일 값이면 먼저 발견한 좌표 유지
                    if (currentTime > bestTime) {
                        bestTime = currentTime;
                        bestRow = r;
                        bestCol = c - w + 1;
                    }
                }
            }
        }
        
        return new int[] {bestRow, bestCol};
    }
}