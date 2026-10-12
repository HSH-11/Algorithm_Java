import java.util.*;

// Point!
// 최소성을 먼저 검사하면 유일성을 검사할 필요가 없는 조합을 미리 걸러낼 수 있음
class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int columnCount = relation[0].length;
        
        // 1. 모든 컬럼 조합 생성
        makeCombinations(columnCount);
        
        // 2. 후보키 저장
        List<List<Integer>> candidates = new ArrayList<>();
        
        for (List<Integer> combination : combinations) {
            
            // 3. 최소성 검사
            if (!isMinimal(combination, candidates)) {
                continue;
            }
            
            // 4. 유일성 검사
            if (isUnique(relation, combination)) {
                candidates.add(combination);
            }
            
        }

        return candidates.size();
    }
    
    private void makeCombinations(int columnCount) {
        for (int size = 1; size <= columnCount; size++) {
            dfs(0, size, new ArrayList<>(), columnCount);
        }
    }
    
    private void dfs(int start, int size, List<Integer> current, int columnCount) {
        
        // 목표 개수만큼 선택하면 조합 완성
        if (current.size() == size) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < columnCount; i++) {
            current.add(i);
            
            dfs(i + 1, size, current, columnCount);
            
            current.remove(current.size() - 1);
        }
    }
    
    // 최소성 검사
    private boolean isMinimal(List<Integer> combination,
                             List<List<Integer>> candidates) {
        
        for (List<Integer> candidate : candidates) {
            // 기존 후보키가 현재 조합에 모두 포함되어 있다면
            if (combination.containsAll(candidate)) {
                return false;
            }
            
        }
        
        return true;
    }
    
    // 유일성 검사
    private boolean isUnique(String[][] relation,
                            List<Integer> combination) {
        
        Set<String> set = new HashSet<>();
        
        for (String[] row : relation) {
            StringBuilder key = new StringBuilder();
            
            for (int col : combination) {
                // 값의 경계가 모호해지지 않도록 길이와 구분자를 사용
                String value = row[col];
                key.append(value.length())
                    .append(':')
                    .append(value)
                    .append('|');
            }
            
            set.add(key.toString());
        }
        
        // 모든 행의 조합이 서로 다르면 유일성 만족
        return set.size() == relation.length;     
    }
}