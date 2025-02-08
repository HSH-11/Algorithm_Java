import java.util.HashMap;

public class Solution {

    private static boolean isInBounds(int x, int y, int dx, int dy) {
        return Math.abs(x + dx) <= width && Math.abs(y + dy) <= height;
    }

    private static  int width, height;

    public int[] solution(String[] keyinput, int[] board) {
        
        int x = 0, y = 0;
       
        HashMap<String, int[]> moves = new HashMap<>();
        moves.put("up", new int[]{0, 1});
        moves.put("down", new int[]{0, -1});
        moves.put("left", new int[]{-1, 0});
        moves.put("right", new int[]{1, 0});
        
        width = board[0] / 2;
        height = board[1] / 2;

        for (String key : keyinput) {
            
            int dx = moves.get(key)[0];
            int dy = moves.get(key)[1];
           
            if (isInBounds(x, y, dx, dy)) {
                x += dx;
                y += dy;
            }
        }

        return new int[]{x, y};
    }

}