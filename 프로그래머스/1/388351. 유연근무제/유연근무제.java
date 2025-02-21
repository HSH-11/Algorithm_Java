class Solution {
    static int solution(int[] schedules, int[][] timelogs, int startday) {
		
		int result = 0;
		//직원수
		int n = schedules.length;
		
		for (int i = 0; i < n; i++) {
			int deadline = addMinutes(schedules[i], 10);
			boolean pass = true;
			for (int j = 0; j < 7; j++) {
				if ( (j+startday) % 7 == 0 || (j+startday) % 7 == 6) continue;
				if (deadline < timelogs[i][j]) {
					pass = false;
					break;
				}
			}
			if (pass) result++;			
		}
						
		
         return result;
	}
	
	static int addMinutes(int time, int minutes) {
        int hour = time / 100;
        int minute = time % 100;

        minute += minutes;
        if (minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        }

        return hour * 100 + minute;
    }
}