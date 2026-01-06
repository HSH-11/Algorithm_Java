class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                answer += i; // 작은 약수 더하기
                if (i * i != n) { // 제곱수가 아니라면 반대편 약수도 더하기
                    answer += n / i;
                }
            }
        }
        return answer;
    }
}