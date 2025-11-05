import java.io.*;
import java.util.*;

public class Main {

    // 나이트의 8방향 이동
    static final int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 체스판 크기
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 나이트의 시작 위치
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            
            // 나이트의 목표 위치
            st = new StringTokenizer(br.readLine());
            int targetY = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken());
            
            // BFS를 통해 최단 이동 횟수 구하기
            sb.append(bfs(N, startY, startX, targetY, targetX)).append("\n");
        }
        
        // 결과 출력
        System.out.println(sb);
    }

    // BFS 함수
    static int bfs(int N, int startY, int startX, int targetY, int targetX) {
        boolean[][] visited = new boolean[N][N];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startY, startX, 0}); // 시작 위치와 이동 횟수 0
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0], x = current[1], moves = current[2];

            // 목표 위치에 도달하면 바로 반환
            if (y == targetY && x == targetX) {
                return moves;
            }

            // 8방향으로 이동
            for (int d = 0; d < 8; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                // 범위 밖인 경우 무시
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) {
                    continue;
                }
                
                // 이동할 위치 방문 처리
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx, moves + 1});
            }
        }
        
        // 목표를 찾을 수 없을 경우 (문제 조건상 도달 불가하면 안됨)
        return -1;
    }
}
