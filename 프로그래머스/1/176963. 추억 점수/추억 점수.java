import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            int totalScore = 0;
            String[] currentPhoto = photo[i];
            
            for (String person : currentPhoto) {
                totalScore += scoreMap.getOrDefault(person,0);
            }
            
            answer[i] = totalScore;
        }
        return answer;
    }
}