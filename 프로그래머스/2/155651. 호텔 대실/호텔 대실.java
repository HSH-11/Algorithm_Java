import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        
        // 1. 입실 시간 기준 오름차순 정렬
        Arrays.sort(book_time, (a,b) -> a[0].compareTo(b[0]));
        
        // 2. 종료 시간 관리 (가장 이른 시간 우선)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String[] book : book_time) {
            int start = timeToMin(book[0]);
            int end = timeToMin(book[1]) + 10;
            
            if (!pq.isEmpty() && pq.peek() <= start) {
                // 가장 빨리 비는 방의 퇴실 시간이 현재 손님의 입실 시간보다 작거나 같으면 방 비워줌
                pq.poll();
            }
            pq.add(end);
        }
        
        return pq.size();
    }
    
    
    private int timeToMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}