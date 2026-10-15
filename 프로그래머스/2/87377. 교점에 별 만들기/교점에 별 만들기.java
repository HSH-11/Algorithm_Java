import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> points = new ArrayList<>();
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        // 1. 모든 직선 쌍의 교점 탐색
        for (int i = 0; i < line.length; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                long denominator = A * D - B * C;

                // 평행하거나 일치하는 직선
                if (denominator == 0) continue;

                long numeratorX = B * F - E * D;
                long numeratorY = E * C - A * F;

                // 정수 좌표인 교점만 선택
                if (numeratorX % denominator != 0 ||
                    numeratorY % denominator != 0) {
                    continue;
                }

                long x = numeratorX / denominator;
                long y = numeratorY / denominator;

                points.add(new long[]{x, y});

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }    
        // 2. 별을 그릴 배열 생성
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] board = new char[height][width];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        // 3. 교점 위치에 별 표시
        for (long[] point : points) {
            // y축 방향을 배열의 행 방향에 맞게 뒤집기
            int row = (int) (maxY - point[1]);
            int col = (int) (point[0] - minX);

            board[row][col] = '*';
        }
            
        // 4. 문자열 배열로 변환
        String[] answer = new String[height];

        for (int i = 0; i < height; i++) {
            answer[i] = new String(board[i]);
        }        
            
        return answer;
    }
}