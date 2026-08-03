class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[] result = new int[queries.length];
        
        // 행렬 생성 및 초기화 (1-based)
        int[][] arr = new int[rows+1][columns+1];
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = (i-1) * columns + j; 
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
           result[i] = rotate(arr, x1, y1, x2, y2);

        }
        
        return result;
    }
    
    
    private int rotate(int[][] arr, int x1, int y1, int x2, int y2) {
        
        int temp = arr[x1][y1];
        int min = temp;
        
        // ↑ 왼쪽
        for (int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i+1][y1];
            min = Math.min(min, arr[i][y1]);
        }
        
        // ← 아래
        for (int j = y1; j < y2; j++) {
            arr[x2][j] = arr[x2][j+1];
             min = Math.min(min, arr[x2][j]);
        }
        
        // ↓ 오른쪽
        for (int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i-1][y2];
            min = Math.min(min, arr[i][y2]);

        }
        
        // → 위
        for (int j = y2; j > y1; j--) {
            arr[x1][j] = arr[x1][j-1];
            min = Math.min(min, arr[x1][j]);
        }
        
        arr[x1][y1+1] = temp;
        
        return min;
      
    }
}