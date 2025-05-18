import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 노드 수
            int n = Integer.parseInt(st.nextToken()); // 간선 수

            if (m == 0 && n == 0) break;

            parent = new int[m];
            for (int i = 0; i < m; i++) parent[i] = i;

            List<Edge> edges = new ArrayList<>();
            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges.add(new Edge(u, v, cost));
                totalCost += cost;
            }

            // 간선 비용 오름차순 정렬
            Collections.sort(edges);

            int mstCost = 0, count = 0;
            for (Edge edge : edges) {
                if (union(edge.u, edge.v)) {
                    mstCost += edge.cost;
                    if (++count == m - 1) break;
                }
            }

            System.out.println(totalCost - mstCost);
        }
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        parent[py] = px;
        return true;
    }
}

