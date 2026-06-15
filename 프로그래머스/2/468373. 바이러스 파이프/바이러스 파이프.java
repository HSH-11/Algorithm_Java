import java.util.*;

class Solution {
    
    int k;
    int maxInfected = 0;
    List<int[]>[] graph;
    int[] sequence;
    int infection;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        
        this.k = k;
        this.infection = infection;
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            
            graph[x].add(new int[]{y, type});
            graph[y].add(new int[]{x, type});
        }
        
        sequence = new int[k];
        
        dfs(0);

        return maxInfected;
    }
    
    private void dfs(int depth) {
        
        if (depth == k) {
            maxInfected = Math.max(maxInfected, simulate());
            return;
        }
        
        for (int type = 1; type <= 3; type++) {
            // 같은 타입 연속 사용 방지
            if (depth > 0 && sequence[depth - 1] == type) {
                continue;
            }
            
            sequence[depth] = type;
            dfs(depth + 1);
        }
    }
    
    private int simulate() {
        
        boolean[] infected = new boolean[graph.length];
        infected[infection] = true;
        
        for (int pipeType : sequence) {
            
            Queue<Integer> q = new ArrayDeque<>();
            
            for (int node = 1; node < graph.length; node++) {
                if (infected[node]) {
                    q.offer(node);
                }
            }
            
            while(!q.isEmpty()){
                
                int cur = q.poll();
                
                for (int[] edge : graph[cur]) {
                    
                    int next = edge[0];
                    int type = edge[1];
                    
                    if (type != pipeType) continue;
                    if (infected[next]) continue;
                    
                    infected[next] = true;
                    q.offer(next);
                }
            }
        }
        
        int count = 0;
        
        for (int node = 1; node < graph.length; node++) {
            if (infected[node]) {
                count++;
            }
        }

        return count;
        
    }
}