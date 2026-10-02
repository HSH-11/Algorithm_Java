import java.util.*;

class Solution {
    
    /* 순열을 실제로 생성하면서 k번째에서 멈추는 게 아니라, k가 어느 순열 그룹에 속하는지를 팩토리얼로 계산해서 바로 k번째 순열을 찾아가는 문제 */
    
    public int[] solution(int n, long k) {
        
        // 사용 가능한 숫자
        List<Integer> numbers = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // 팩토리얼 계산
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        int[] answer = new int[n];
        
        k--; // 0-based
            
        for (int i = 0; i < n; i++) {
            
            // 현재 자리에서 하나의 숫자가 차지하는 순열 개수
            long count = factorial[n-1-i];
            
            // 선택할 숫자의 인덱스
            int index = (int)(k / count);
            
            answer[i] = numbers.get(index);
            numbers.remove(index);
            
            // 해당 그룹 안에서 몇 번째인지
            k %= count;
            
        }
        
        return answer;
    }
    

}