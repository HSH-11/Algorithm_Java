import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, sharkSize = 2, cnt = 0;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Fish {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        int startX = -1, startY = -1;
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 아기 상어 위치
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }
        
        System.out.println(bfs(startX, startY)); 
    }

    public static int bfs(int startX, int startY) {
        Deque<Fish> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new Fish(startX, startY, 0));
        visited[startX][startY] = true;

        int totalTime = 0;

        while (!queue.isEmpty()) {
            List<Fish> eatableFishes = new ArrayList<>();
            int size = queue.size();
            
            while (size-- > 0) {
                Fish current = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] <= sharkSize) {
                        //아직 방문 X, 사이즈가 현재 아기 상어보다 작다면 
                    	visited[nx][ny] = true;
                        if (map[nx][ny] == 0 || map[nx][ny] == sharkSize) {
                        // 이동 가능한 경우 bfs 큐에 추가
                            queue.offer(new Fish(nx, ny, current.dist + 1));
                        } else if (map[nx][ny] < sharkSize && map[nx][ny] > 0) {
                        	// 이동 중에 자기보다 작은 먹을 물고기 찾음
                            eatableFishes.add(new Fish(nx, ny, current.dist + 1));
                        }
                    }
                }
            }
            //먹을 수 있는 물고기가 있다면 거리가 가까운 물고기부터 먹도록
            if (!eatableFishes.isEmpty()) {
                Collections.sort(eatableFishes, (f1, f2) -> {
                    if (f1.dist == f2.dist) {
                        if (f1.x == f2.x) {
                            return f1.y - f2.y;
                        }
                        return f1.x - f2.x;
                    }
                    return f1.dist - f2.dist;
                });

                Fish fishToEat = eatableFishes.get(0);
                map[fishToEat.x][fishToEat.y] = 0;
                totalTime += fishToEat.dist;
                cnt++;

                if (cnt == sharkSize) {
                    sharkSize++;
                    cnt = 0;
                }
                
                //아기 상어가 물고리를 먹은 후의 상태 초기화
                //큐를 비워야 아기 상어가 물고기를 먹은 후의 새로운 상태에서 다시 탐색을 시작
                //방문 기록 역시 초기화
                //새로운 위치에서 탐색을 시작하도록 queue에 추가(아기 상어가 먹은 위치에서 다시 시작)
                queue.clear();
                visited = new boolean[N][N];
                queue.offer(new Fish(fishToEat.x, fishToEat.y, 0));
                visited[fishToEat.x][fishToEat.y] = true;
            }

            if (queue.isEmpty() && eatableFishes.isEmpty()) {
                break;
            }
        }

        return totalTime;
    }
}