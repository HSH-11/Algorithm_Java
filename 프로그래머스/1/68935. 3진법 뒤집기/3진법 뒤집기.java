class Solution {
    public int solution(int n) {
        String ternary = "";
        while (n > 0) {
            ternary += (n % 3);
            n /= 3;
        }
        
        return Integer.parseInt(ternary,3);
    }
}