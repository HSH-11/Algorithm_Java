class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int remainder = storey % 10; // 마지막 자릿수
            storey /= 10; // 나머지 자릿수
            
            if (remainder > 5) {
                // 5보다 크면 무조건 올림
                answer += (10 - remainder);
                storey++; // 올림했으므로 다음 자릿수에 1 더하기
            } else if (remainder < 5) {
                // 5보다 작으면 무조건 내림
                answer += remainder;
            } else {
                // 정확히 5인 경우
                // 다음 자릿수를 보고 올릴지 내릴지 결정
                if (storey % 10 >= 5) {
                    answer += 5;
                    storey++;
                }else {
                    answer += 5;
                }
            }
        }
        return answer;
    }
}