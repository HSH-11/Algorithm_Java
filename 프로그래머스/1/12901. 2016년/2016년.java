class Solution {
    public String solution(int a, int b) {
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        for (int i = 0; i < a-1; i++) {
            totalDays += months[i];
        }
        
        totalDays += b;
        
        return days[(totalDays - 1) % 7];
    }
}