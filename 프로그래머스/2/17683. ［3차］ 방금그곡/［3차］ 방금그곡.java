class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = -1;
        
        // 네오가 기억한 멜로디의 샵 음계 치환
        m = m.replace("C#", "c")
             .replace("D#", "d")
             .replace("F#", "f")
             .replace("G#", "g")
             .replace("A#", "a");
               
        for (String music : musicinfos) {
            
            String[] info = music.split(",");
            
            // 시작시간, 종료시간, 제목, 악보
            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");

            int startHour = Integer.parseInt(startTime[0]);
            int startMin = Integer.parseInt(startTime[1]);

            int endHour = Integer.parseInt(endTime[0]);
            int endMin = Integer.parseInt(endTime[1]);
            
            // 실제 재생 시간(분)
            int playingTime = (endHour * 60 + endMin) - (startHour * 60 + startMin);   
            
            
            // 악보의 샵 음계 치환
            String melody = info[3]
                    .replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");
            
            // 재생 시간만큼 실제 연주된 멜로디
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < playingTime; i++) {
                sb.append(melody.charAt(i % melody.length()));
            }
                       
            String entireMelody = sb.toString();
            
            // 기억한 멜로디가 포함되고, 재생 시간이 더 긴 곡이면 갱신
            if (entireMelody.contains(m) && playingTime > maxPlayTime) {
                answer = info[2];
                maxPlayTime = playingTime;
            } 
                      
        }
  
        return answer.isEmpty() ? "(None)" : answer;
    }
}