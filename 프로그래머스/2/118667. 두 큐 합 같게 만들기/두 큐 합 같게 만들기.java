class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        
        int n = queue1.length;
        
        int[] queue = new int[n * 2];
        
        for (int i = 0; i < n; i++) {
            queue[i] = queue1[i];
            sum1 += queue1[i];
        }
        
        for (int i = 0; i < n; i++) {
            queue[n + i] = queue2[i];
            sum2 += queue2[i];
        }
        
        long total = sum1 + sum2;

        if (total % 2 != 0) {
            return -1;
        }

        long target = total / 2;
        
        int left = 0;
        int right = n;
        int cnt = 0;

        
        while (left < 2 * n && right < 2 * n) {
            
            if (sum1 == target) return cnt;
            
            if (sum1 > target) {
                // queue1 -> queue2
                sum1 -= queue[left++];
                
            } else {
                // queue2 -> queue1 
                sum1 += queue[right++];
             
            }
            
            cnt++;
            
        }
        
        return -1;
    }
}