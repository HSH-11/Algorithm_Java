class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0; // 단어별 인덱스를 관리할 변수

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                cnt = 0; // 공백을 만나면 카운트 리셋
                answer.append(" ");
            } else {
                // 짝수면 대문자, 홀수면 소문자
                if (cnt % 2 == 0) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                cnt++; // 문자를 처리했을 때만 카운트 증가
            }
        }
        return answer.toString();
    }
}