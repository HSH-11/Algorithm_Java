import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<String, String>();
        
        for(String line : record) {
        	String[] cmd = line.split(" ");
        	if (!cmd[0].equals("Leave")) {
        		map.put(cmd[1],cmd[2]);
        	}
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        for(String line : record) {
        	String[] cmd = line.split(" ");
        	if (cmd[0].equals("Enter")) {
        		answer.add(map.get(cmd[1]) + "님이 들어왔습니다.");
        	}
        	else if (cmd[0].equals("Leave")) {
        		answer.add(map.get(cmd[1]) + "님이 나갔습니다.");
        	}
        }
        
        return answer.toArray(new String[0]);
    }
}