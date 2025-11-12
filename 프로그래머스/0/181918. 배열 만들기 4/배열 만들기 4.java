import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();
        
        int idx = 0;
        int len = arr.length;
        while(idx < arr.length) {
            if (idx < len) {
                // 빈 배열
                if (stk.size() == 0) {
                    stk.add(arr[idx]);
                    idx++;
                }else { // 원소 있음
                    if (stk.get(stk.size()-1) < arr[idx]){
                        stk.add(arr[idx]);
                        idx++;
                    }else {
                        stk.remove(stk.size()-1);
                    }
                }
            }
        }
        return stk;
    }
}