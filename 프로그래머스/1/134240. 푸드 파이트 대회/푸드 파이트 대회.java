class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        // 1. 왼쪽 선수 음식 배치 생성
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        
        String toRight = sb.toString();
        String toLeft = sb.reverse().toString();
     
        return toRight + "0" + toLeft;
    }
}