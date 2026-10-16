class Solution {
    
    // 만들 수 있는 최대 리프 노드 수
    private long answer;
    
    // 사용할 수 있는 분배 노드의 최대 개수
    private long distLimit;
    
    // 리프 노드의 분배도 최댓값
    private long splitLimit;
    
    public int solution(int dist_limit, int split_limit) {
        
        distLimit = dist_limit;
        splitLimit = split_limit;

        // 루트의 자식 노드 1개는 아직 분배하지 않은 상태이므로 리프 수의 초기 최댓값은 1
        answer = 1;
        
        // 현재 노드 수, 사용한 분배 노드 수, 현재 분배도, 이미 확정한 리프 수
        dfs(1L, 0L, 1L, 0L);

        // 문제의 반환 타입에 맞춰 최댓값 반환
        return (int) answer;
    }
    
    private void dfs(long cur, long used, long split, long leaf) {

        // 현재 노드를 더 이상 분배하지 않으면 모두 리프가 되므로 정답 갱신
        answer = Math.max(answer, leaf + cur);

        // 분배 노드 사용 한도를 모두 소진했다면 더 이상 확장할 수 없음
        long remain = distLimit - used;

        if (remain <= 0) {
            return;
        }

        // 현재 깊이의 분배 노드가 자식을 2개 또는 3개 갖는 두 경우 탐색
        for (int child : new int[]{2, 3}) {

            // 다음 단계의 분배도가 제한을 초과하면 해당 방향으로 분배할 수 없음
            // 곱셈으로 제한을 넘기지 않도록 나눗셈으로 먼저 검사
            if (split > splitLimit / child) {
                continue;
            }

            // 현재 깊이에서 분배할 노드 수
            // 분배 노드 한도와 현재 노드 수 중 작은 값만 분배
            long use = Math.min(cur, remain);

            // 분배하지 않은 현재 노드는 리프로 확정
            long nextLeaf = leaf + (cur - use);

            // 분배한 노드들이 만드는 다음 깊이의 노드 수
            long nextCur = use * child;

            // 다음 깊이로 이동하며 분배 노드 사용량과 분배도 갱신
            long nextUsed = used + use;
            long nextSplit = split * child;

            // 다음 깊이에서 자식 수 2 또는 3을 선택하는 경우를 재귀적으로 탐색
            dfs(nextCur, nextUsed, nextSplit, nextLeaf);
        }
    }
}