import java.util.*;

class Solution {
    List<int[]> moves = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return moves.toArray(new int[moves.size()][]);
    }
    
    private void hanoi(int n, int start, int end, int temp) {
        if (n == 1) {
            moves.add(new int[]{start, end});
            return;
        }
        
        // 1. 위의 n-1개의 원판을 보조 기둥으로 이동
        hanoi(n - 1, start, temp, end);
        
        // 2. 가장 큰 원판을 목적지로 이동
        moves.add(new int[]{start, end});
        
        // 3. 보조 기둥의 n-1개의 원판을 목적지로 이동
        hanoi(n - 1, temp, end, start);
    }
}