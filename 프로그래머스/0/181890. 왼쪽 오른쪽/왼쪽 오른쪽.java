import java.util.*;
class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        int idx = 0;
        for (String str : str_list){
            if (str.equals("l")){
                answer = Arrays.copyOfRange(str_list,0,idx);
                break;
            }
            if (str.equals("r")){
                answer = Arrays.copyOfRange(str_list,idx+1,str_list.length);
                break;
            }
            idx++;
        }
        return answer;
    }
}