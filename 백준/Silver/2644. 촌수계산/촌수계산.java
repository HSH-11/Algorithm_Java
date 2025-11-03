import java.io.*;
import java.util.*;

public class Main {
    static int N, p1, p2;
    static ArrayList<Integer>[] relation;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        relation = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) relation[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation[x].add(y);
            relation[y].add(x);
        }

        visited = new boolean[N + 1];
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{p1, 0});
        visited[p1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cnt = cur[1];

            if (now == p2) return cnt;

            for (int next : relation[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }
        return -1;
    }
}