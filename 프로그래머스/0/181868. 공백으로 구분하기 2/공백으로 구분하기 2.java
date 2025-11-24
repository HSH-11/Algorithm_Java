class Solution {
    public String[] solution(String my_string) {
        // 하나 이상의 공백 "\\s+"
        String[] answer = my_string.trim().split("\\s+");
        return answer;
    }
}