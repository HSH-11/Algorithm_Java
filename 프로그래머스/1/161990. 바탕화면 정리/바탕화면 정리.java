class Solution {
    public int[] solution(String[] wallpaper) {
        // 초기값은 가질 수 있는 최대/최소 범위의 반대로 설정
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        
        int rows = wallpaper.length;
        int cols = wallpaper[0].length();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // 파일(#)을 발견하면 좌표를 비교하여 갱신
                if (wallpaper[r].charAt(c) == '#') {
                    minR = Math.min(minR, r);
                    minC = Math.min(minC, c);
                    maxR = Math.max(maxR, r);
                    maxC = Math.max(maxC, c);
                }
            }
        }
        
        // 끝점은 좌표 + 1을 해줘야 함
        return new int[]{minR, minC, maxR + 1, maxC + 1};
    }
}