class Solution {
    public int solution(int[][] signals) {
        
        int[] periods = new int[signals.length];
        
        for (int i = 0; i < signals.length; i++) {
            periods[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        
        int limit = periods[0];
        for (int i = 1; i < periods.length; i++) {
            limit = lcm(limit, periods[i]);
        }
        
        // 1초부터 LCM까지 확인
        for (int t = 1; t <= limit; t++) {
            boolean allYellow = true;
            
            for (int i = 0; i < signals.length; i++) {
                
                int G = signals[i][0];
                int Y = signals[i][1];
                
                // 현재 주기에서 몇 초째인지
                int time = (t-1) % periods[i];
                
                // 노란불이 아니면 실패
                if (time < G || time >= G + Y) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return t;
            }
            
        }
        
        return -1;
        
        
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        } 
        return a;
    }
    
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}