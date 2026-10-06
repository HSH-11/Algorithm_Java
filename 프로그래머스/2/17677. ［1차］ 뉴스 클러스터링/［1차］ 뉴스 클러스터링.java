import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        // 문자열 추출 및 유효성 검사
        for (int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i,i+2);
            
            if (Character.isLetter(sub.charAt(0)) && Character.isLetter(sub.charAt(1))) {
                map1.put(sub, map1.getOrDefault(sub,0) + 1);
            }
            
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i,i+2);
            
            if (Character.isLetter(sub.charAt(0)) && Character.isLetter(sub.charAt(1))) {
                map2.put(sub, map2.getOrDefault(sub,0) + 1);
            }
            
        }
        
        // 자카드 유사도 계산
        int intersection = 0;
        int union = 0;
        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        for (String key : keys) {
            int count1 = map1.getOrDefault(key,0);
            int count2 = map2.getOrDefault(key,0);
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        
        if (union == 0) return 65536;
        
        double similarity = (double) intersection / union;
        
  
        return (int)(similarity * 65536);
    }
}