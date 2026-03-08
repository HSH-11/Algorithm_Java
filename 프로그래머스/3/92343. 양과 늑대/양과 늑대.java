import java.util.*;

class Solution {
    List<Integer>[] tree;
    int[] info;
    boolean[] visitedMask;
    int answer = 0;
    int n;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.n = info.length;
        this.tree = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        // 방문 상태는 최대 2^n
        visitedMask = new boolean[1 << n];

        // 0번은 항상 루트, 문제 조건상 양
        dfs(1 << 0, 1, 0);

        return answer;
    }

    private void dfs(int mask, int sheep, int wolf) {
        // mask 중복 제거
        if (visitedMask[mask]) return;
        visitedMask[mask] = true;

        answer = Math.max(answer, sheep);

        // 현재 방문 상태(mask)에서 갈 수 있는 다음 노드 탐색
        for (int parent = 0; parent < n; parent++) {
            // parent가 방문된 노드가 아니면 스킵
            if ((mask & (1 << parent)) == 0) continue;

            // 방문된 parent의 자식들 확인
            for (int child : tree[parent]) {
                // 이미 방문한 child면 스킵
                if ((mask & (1 << child)) != 0) continue;

                if (info[child] == 0) {
                    // 양
                    dfs(mask | (1 << child), sheep + 1, wolf);
                } else {
                    // 늑대
                    if (sheep > wolf + 1) {
                        dfs(mask | (1 << child), sheep, wolf + 1);
                    }
                }
            }
        }
    }
}