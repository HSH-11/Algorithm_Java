/* 
    나올 수 없는 경우
    1. 선후공 순서 위반 : cntX > cntO 또는 cntO - cntX  > 1
    2. O가 이겼는데 X를 두는 경우 : O 3목이면서 cntO == cntX
    3. X가 이겼는데 O을 두는 경우 : X 3목이면서 cntO > cntX
  
*/

class Solution {
    public int solution(String[] board) {
        
        int cntO = 0;
        int cntX = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    cntO++;
                }else if (board[i].charAt(j) == 'X') {
                    cntX++;
                }
            }
        }
        
        // 승리 판단
        boolean oWin = checkWin('O', board);
        boolean xWin = checkWin('X', board);
        
        // 순서 위반
        if (cntX > cntO || cntO - cntX > 1) return 0;
        
        // O가 이겼는데 X를 두는 경우
        if (oWin && cntO == cntX) return 0;
        
        // X가 이겼는데 O를 두는 경우
        if (xWin && cntO > cntX) return 0;
        
        return 1;
    }
    
    private boolean checkWin(char mark, String[] board) {
        
        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == mark &&
               board[i].charAt(1) == mark &&
                board[i].charAt(2) == mark) {
                return true;
            }
        }
        
        // 세로
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == mark && 
                board[1].charAt(i) == mark && 
                board[2].charAt(i) == mark) {
                return true;
            }
        }
        
        // 대각선 확인 (좌상단 -> 우하단)
        if (board[0].charAt(0) == mark && 
            board[1].charAt(1) == mark && 
            board[2].charAt(2) == mark) {
            return true;
        }

        // 대각선 확인 (우상단 -> 좌하단)
        if (board[0].charAt(2) == mark && 
            board[1].charAt(1) == mark && 
            board[2].charAt(0) == mark) {
            return true;
        }

        return false;

    }
}