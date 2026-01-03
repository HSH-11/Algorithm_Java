class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        
        // 첫번째 학생 선택
        for (int i = 0 ; i < n; i++) {
            // 두번째 학생 선택
            for (int j = i + 1; j < n; j++) {
                // 세번째 학생 선택
                for (int k = j + 1; k < n; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}