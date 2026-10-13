class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for (int num = 0; sb.length() < m * t; num++) {
            sb.append(Integer.toString(num, n).toUpperCase());
        }
        
        while (t-- > 0) {
            answer.append(sb.charAt(p-1));
            p += m;
        };

        
        
        return answer.toString();
    }
}