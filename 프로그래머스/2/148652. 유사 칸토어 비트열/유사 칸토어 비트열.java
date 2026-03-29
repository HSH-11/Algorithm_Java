// n번째 유사 칸토어 비트열은 n-1번째에서 1을 11011로 0을 00000로 치환
// 5구역 중 가운데만 통째로 0
// n = 0                  1
// n = 1                11011
// n = 2    11011 11011 00000 11011 11011
class Solution {
    public int solution(int n, long l, long r) {
        return (int) (countOne(n, r-1) - countOne(n, l - 2));
    }
    
    private long countOne(int n, long k) {
        if (n == 0) return 1;
        
        long pLen = (long) Math.pow(5, n-1); // 이전 단계 길이
        long pCount = (long) Math.pow(4, n-1); // 이전 단계 1의 개수
        
        int section = (int) (k / pLen);
        long remainder = k % pLen;
        
        long res = 0;
        
        if (section < 2) {
            res = section * pCount + countOne(n-1, remainder);
        } else if (section == 2) {
            res = 2 * pCount;
        } else {
            res = (section - 1) * pCount + countOne(n-1, remainder);
        }
        
        return res;
    }
}