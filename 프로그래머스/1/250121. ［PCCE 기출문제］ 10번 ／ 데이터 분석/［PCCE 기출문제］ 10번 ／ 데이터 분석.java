import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 각 컬럼 명칭에 맞는 인덱스 매핑
        Map<String, Integer> columnMap = new HashMap<>();
        columnMap.put("code", 0);
        columnMap.put("date", 1);
        columnMap.put("maximum", 2);
        columnMap.put("remain", 3);
        
        int extIdx = columnMap.get(ext);
        int sortIdx = columnMap.get(sort_by);
        
        // 조건에 맞는 데이터 필터링
        List<int[]> filteredList = new ArrayList<>();
        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                filteredList.add(d);
            }
        }
        
        // 정렬 기준에 맞춰 오름차순 정렬
        Collections.sort(filteredList, (a, b) -> a[sortIdx] - b[sortIdx]);
        
        // List를 다시 2차원 배열로 변환하여 반환
        int[][] answer = new int[filteredList.size()][4];
        for (int i = 0; i < filteredList.size(); i++) {
            answer[i] = filteredList.get(i);
        }
        
        return answer;
    }
}