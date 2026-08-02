class Solution {
    public int solution(int n, int k) {
        // n을 k진수 문자열로 변환
        String s = Integer.toString(n, k);
        String[] nums = s.split("0");
        
        int result = 0;
        
        for (String num : nums) {
            
            if (num.isEmpty()) continue;
            
            long value = Long.parseLong(num);
            
            if (isPrime(value)) result++; 
            
        }

        return result;
    }
    
    private boolean isPrime(long n) {
        
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        
        for (long i = 3; i * i <= n; i+= 2) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}