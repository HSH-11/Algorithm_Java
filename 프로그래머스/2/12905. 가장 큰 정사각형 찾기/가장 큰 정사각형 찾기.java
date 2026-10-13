class Solution
{
    public int solution(int [][]board)
    {
        int rows = board.length;
        int cols = board[0].length;
        int max = 0;
        
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, board[i][0]);
        }
        
        for (int j = 0; j < cols; j++) {
            max = Math.max(max, board[0][j]);
        }     
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 1 + Math.min(board[i - 1][j], Math.min(board[i][j-1], board[i-1][j-1]));
                    
                    max = Math.max(max,board[i][j]);
                }
            }
        }
                

        return max * max;
    }
}