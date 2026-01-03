class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0; // 긴 변들 중의 최댓값;
        int maxH = 0; // 짧은 변들 중의 최댓값;
        
        for (int[] size : sizes) {
            int length = Math.max(size[0],size[1]);
            int width = Math.min(size[0],size[1]);
            
            maxW = Math.max(maxW,length);
            maxH = Math.max(maxH,width);
        }
        return maxW * maxH;
    }
}