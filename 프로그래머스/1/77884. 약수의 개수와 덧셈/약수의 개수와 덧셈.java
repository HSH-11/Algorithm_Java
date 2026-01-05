class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        // 제곱수는 약수의 개수가 홀수다
        for (int i = left; i <= right; i++) {
            // i의 제곱근을 구해서 다시 제곱했을 때 i가 되면 제곱수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }else {
                answer += i;
            }
        }
        return answer;
    }
}