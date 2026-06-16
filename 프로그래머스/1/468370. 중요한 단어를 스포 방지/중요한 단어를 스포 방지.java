import java.util.*;

class Solution {
    
    static class Word {
        String text;
        int start;
        int end;
        boolean spoiler;
        
        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = new ArrayList<>();
        
        int start = 0;
        
        // 1. 단어 파싱 및 인덱스 계산
        for (int i = 0; i <= message.length(); i++) {
            
            if (i == message.length() || message.charAt(i) == ' ') {
                words.add(
                    new Word(
                        message.substring(start,i),
                        start,
                        i - 1
                    )
                );
                start = i + 1;
            }
        }
        
        // 2. 스포 단어 판별
        for (Word word : words) {
            
            for (int[] range : spoiler_ranges) {
                
                int s = range[0];
                int e = range[1];
                
                if (word.start <= e && s <= word.end) {
                    word.spoiler = true;
                    break;
                }
            }
        }
        
        // 3. 비스포 단어 저장
        Set<String> normalWords = new HashSet<>();
        
        for (Word word : words) {
            if (!word.spoiler) {
                normalWords.add(word.text);
            }
        }
        
        // 4. 중요한 단어 계산
        Set<String> importantWords = new HashSet<>();
        int answer = 0;
        
        for (Word word : words) {
            
            if (!word.spoiler) continue;
            
            // 비스포 구간에 등장한 적 없어야 함
            if (normalWords.contains(word.text)) continue;
            
            // 이미 중요한 단어로 카운트된 적 없어야 함
            if (importantWords.contains(word.text)) continue;
            
            importantWords.add(word.text);
            answer++;
        }
        
        
        return answer;
    }
}