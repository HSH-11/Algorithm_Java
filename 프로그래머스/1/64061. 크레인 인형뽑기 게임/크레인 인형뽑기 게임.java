import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        List<Stack<Integer>> columns = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            columns.add(new Stack<>());
        }

        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] != 0) {
                    columns.get(col).push(board[row][col]);
                }
            }
        }

        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            Stack<Integer> colStack = columns.get(move - 1);
            if (!colStack.isEmpty()) {
                int doll = colStack.pop();
                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(doll);
                }
            }
        }
        return answer;
    }
}
