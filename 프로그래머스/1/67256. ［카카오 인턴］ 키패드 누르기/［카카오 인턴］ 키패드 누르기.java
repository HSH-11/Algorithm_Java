class Solution {
    int[][] pos = {
            {3,1},
            {0,0}, {0,1}, {0,2},
            {1,0}, {1,1}, {1,2},
            {2,0}, {2,1}, {2,2},
            {3,0}, {3,2} // * (10), # (11)
    };
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 11;
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            } else {
                // 거리 비교
                int dLeft = getDist(pos[left], pos[num]);
                int dRight = getDist(pos[right], pos[num]);
                
                if (dLeft < dRight) {
                    sb.append("L");
                    left = num;
                }else if (dLeft > dRight) {
                    sb.append("R");
                    right = num;
                }else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = num;
                    }else {
                        sb.append("R");
                        right = num;
                    }
                }
                
            }
        }
        
        
        return sb.toString();
    }
    
    private int getDist(int[] p1, int[] p2) {
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
}