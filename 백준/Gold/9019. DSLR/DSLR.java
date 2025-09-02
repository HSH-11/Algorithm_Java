import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(bfs(A, B) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static String bfs(int start, int target) {
        boolean[] visited = new boolean[MAX];
        int[] parent = new int[MAX];
        char[] how = new char[MAX];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        parent[start] = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == target) break;

            int[] next = {D(cur), S(cur), L(cur), R(cur)};
            char[] cmd = {'D', 'S', 'L', 'R'};

            for (int i = 0; i < 4; i++) {
                int nx = next[i];
                if (!visited[nx]) {
                    visited[nx] = true;
                    parent[nx] = cur;
                    how[nx] = cmd[i];
                    queue.offer(nx);
                }
            }
        }

        // 경로 역추적
        StringBuilder sb = new StringBuilder();
        int cur = target;
        while (cur != start) {
            sb.append(how[cur]);
            cur = parent[cur];
        }

        return sb.reverse().toString();
    }

    static int D(int n) {
        return (n * 2) % 10000;
    }

    static int S(int n) {
        return (n == 0) ? 9999 : n - 1;
    }

    static int L(int n) {
        return (n % 1000) * 10 + n / 1000;
    }

    static int R(int n) {
        return (n % 10) * 1000 + (n / 10);
    }
}
