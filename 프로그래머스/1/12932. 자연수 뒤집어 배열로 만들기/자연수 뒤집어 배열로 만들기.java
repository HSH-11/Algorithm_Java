class Solution {
    public int[] solution(long n) {
        String s = new StringBuilder(String.valueOf(n)).reverse().toString();
        
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(i) - '0';
        }
        
        return answer;
    }
}