import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        // 현재 주차 중인 차량
        Map<String, Integer> inTime = new HashMap<>();
        
        // 누적 주차시간 
        Map<String, Integer> totalTime = new HashMap<>();
        
        // records 순회
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String status = record[2];
            String car = record[1];
            int time = toMinute(record[0]);
            
            
            if (status.equals("IN")) {
                inTime.put(car, time);
                
            } else {
                int parked = time-inTime.get(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + parked);
                inTime.remove(car);
            }
            
        }
        
        // 아직 남아있는 차량
        for (String car : inTime.keySet()) {
            int parked = 1439 - inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + parked);
        }
        
        // 차량번호 정렬
        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        
        // 요금 계산
        for (int i = 0; i < cars.size(); i++) {
            
            int total = totalTime.get(cars.get(i));
            
            // 기본 요금만 지불
            if (total <= fees[0]) {
                answer[i] = fees[1];
            } else {
                int extra = total - fees[0];
                
                // 올림 처리
                answer[i] = fees[1] + ((extra + fees[2] - 1) / fees[2]) * fees[3];
            }
        }
        
        return answer;

    }
    
    private int toMinute(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        
        return hour * 60 + minute;
    }
}