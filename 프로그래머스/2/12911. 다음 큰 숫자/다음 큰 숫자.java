class Solution {

    public int solution(int n) {
        int c = n;
        
        // 1. 오른쪽 끝의 연속된 0의 개수
        int zeroCount = 0;
        while ((c & 1) == 0) {
            zeroCount++;
            c >>= 1;
        }
        
        // 2. 그 앞의 연속된 1 개수
        int oneCount = 0;
        while ((c & 1) == 1) {
            oneCount++;
            c >>= 1;
        }
        
        // 3. 가장 오른쪽의 01패턴을 10으로 변경
        int position = zeroCount + oneCount;
        n |= (1 << position);
        n &= ~((1 << position) - 1);
        // 남은 1을 오른쪽에 배치
        n |= (1 << (oneCount - 1)) - 1;
        //   1001110  (78)
        // | 0010000  (16)
        // ---------
        //   1011110  (94)
        //   0001111
        // ~ 1110000
        // ---------
        //   1010000  (80)
        // | 0000011  (3)
        // ---------
        //   1010011  (83)
        
        return n;
    
    }
}