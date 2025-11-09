import java.util.*;

class Solution {
    static List<String> answer;
    static boolean found = false;

    public String[] solution(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String[] t : tickets)
            graph.computeIfAbsent(t[0], k -> new ArrayList<>()).add(t[1]);

        // 사전순 정렬
        for (List<String> list : graph.values())
            Collections.sort(list);

        answer = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", graph, path, tickets.length);

        return answer.toArray(new String[0]);
    }

    void dfs(String cur, Map<String, List<String>> graph, List<String> path, int total) {
        if (found) return;

        if (path.size() == total + 1) {
            answer = new ArrayList<>(path);
            found = true;
            return;
        }

        if (!graph.containsKey(cur)) return;

        List<String> nexts = graph.get(cur);
        for (int i = 0; i < nexts.size(); i++) {
            String next = nexts.get(i);
            nexts.remove(i);            // 티켓 사용
            path.add(next);
            dfs(next, graph, path, total);
            path.remove(path.size() - 1);
            nexts.add(i, next);         // 티켓 복원
            if (found) return;          // 첫 경로 찾으면 중단
        }
    }
}
