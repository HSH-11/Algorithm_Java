class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] count = new int[number + 1];
        
        // 배수 원리를 이용한 약수 개수 계산
        for (int i = 1; i <= number; i++ ) {
            for (int j = i; j <= number; j += i) {
                count[j]++;
            }
        }
        
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}