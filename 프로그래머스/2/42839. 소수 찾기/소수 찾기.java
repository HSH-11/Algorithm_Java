import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    char[] nums;
     
    public int solution(String numbers) {
        
        nums = numbers.toCharArray();
        visited = new boolean[nums.length];
        
        permutation("");
        
        int answer = 0;
        
        for (int num : set) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    
    private void permutation (String current) {
        
        // 길이가 1이상이면 숫자 저장
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        } 
        
        for (int i = 0; i < nums.length; i++) {
            
            if (visited[i]) continue;
            
            visited[i] = true;
            
            permutation(current + nums[i]);
            
            visited[i] = false;
        }
                      
    }
    
    private boolean isPrime(int n) {
        
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i =  3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        
        return true;
        
    }
}