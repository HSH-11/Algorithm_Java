import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n, m;

    public int[] solution(String[] maps) {
        List<Integer> result = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 바다가 아니고 방문하지 않은 섬을 발견하면 DFS 시작
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    result.add(dfs(i, j, maps));
                }
            }
        }

        if (result.isEmpty()) return new int[]{-1};

        // 오름차순 정렬 후 배열로 변환
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int r, int c, String[] maps) {
        visited[r][c] = true;
        int sum = maps[r].charAt(c) - '0';

        // 상하좌우 탐색
        for (int d = 0; d < 4; d++) {
            int ny = r + dy[d];
            int nx = c + dx[d];

            // 1. 범위 체크
            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                // 2. 바다가 아니고 아직 방문하지 않았다면 재귀 호출
                if (maps[ny].charAt(nx) != 'X' && !visited[ny][nx]) {
                    sum += dfs(ny, nx, maps);
                }
            }
        }
        return sum;
    }
}