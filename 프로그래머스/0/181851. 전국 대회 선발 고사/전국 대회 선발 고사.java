import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<rank.length; i++){
            map.put(rank[i], i);
            if(attendance[i]) list.add(rank[i]);
        }
        
        Collections.sort(list);
        
        int a = map.getOrDefault(list.get(0), 0);
        int b = map.getOrDefault(list.get(1), 0);
        int c = map.getOrDefault(list.get(2), 0);
        
        int answer = a*10000 + b*100 + c;
        return answer;
    }
}