import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int r = park.length;
        int c = park[0].length;
        
        // 큰 돗자리부터 탐색 (내림차순 정렬)
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int mat = mats[i];
            
            // 돗자리를 놓을 수 있는 시작 좌표 범위 제한
            for (int y = 0; y <= r - mat; y++) {
                for (int x = 0; x <= c - mat; x++) {
                    if (canPlace(mat, y, x, park)) {
                        return mat;
                    }
                }
            }
        }

        return -1; // 아무것도 못 놓으면 -1
    }

    private boolean canPlace(int mat, int y, int x, String[][] park) {
        for (int i = y; i < y + mat; i++) {
            for (int j = x; j < x + mat; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
