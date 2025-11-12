import java.util.*;
class Solution {
    
    public int OpeningSkip(int op_start, int op_end, int pos) {
        if (op_start <= pos && op_end >= pos) {
            pos = op_end;
        }
        return pos;
    }
        
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int posLen = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int ops = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int ope = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        
        // 오프닝 건너뛰기
        posLen = OpeningSkip(ops,ope,posLen);
        for (String cmd : commands) {
            
            switch (cmd) {
                case "prev" : 
                    posLen = (posLen - 10 < 0 ) ? 0 : posLen - 10;
                    break;
                case "next" : 
                    posLen = (posLen + 10 > videoLen ) ? videoLen : posLen + 10;
                    break;
            }
             // 오프닝 건너뛰기
            posLen = OpeningSkip(ops,ope,posLen);          
        }
        
        return String.format("%02d:%02d", posLen/60, posLen%60);
    }
}