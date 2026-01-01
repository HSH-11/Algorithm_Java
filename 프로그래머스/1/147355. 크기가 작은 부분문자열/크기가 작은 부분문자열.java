class Solution {
    public int solution(String t, String p) {
        int len_p = p.length();
        int result = 0;
        
        // p의 값이 매우 클 수 있으므로 Long으로 변환
        long pValue = Long.parseLong(p);
        
        for (int i = 0; i <= t.length() - len_p; i++) {
            // i부터 len_p만큼의 부분 문자열 추출
            String sub = t.substring(i, i + len_p);
            
            // 추출한 문자열도 Long으로 변환하여 비교
            if (Long.parseLong(sub) <= pValue) {
                result++;
            }
        }
        return result;
    }
}