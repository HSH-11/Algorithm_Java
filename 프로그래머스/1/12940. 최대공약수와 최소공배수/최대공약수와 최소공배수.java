class Solution {
    public int[] solution(int n, int m) {
        // 최대공약수 구하기
        int gcd = getGCD(n,m);
        
        // 최소공배수 구하기
        int lcm = (n * m) / gcd;
        
        return new int[] {gcd, lcm};
    }
    
    public int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}