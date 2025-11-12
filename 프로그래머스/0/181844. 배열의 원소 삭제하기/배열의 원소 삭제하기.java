import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> arrList = new ArrayList<>();
        List<Integer> deleteList = new ArrayList<>();
        for (int i : arr) { 
            arrList.add(i);        
        }
        for (int i : delete_list) { 
            deleteList.add(i);        
        }
        
        arrList.removeAll(deleteList);
        return arrList.stream().mapToInt(i->i).toArray();
    }
}