class Solution {
    public String solution(String phone_number) {
        // .(?=.{4}) : 뒤에 4개의 문자가 더 있는 모든 문자(.)를 선택
        return phone_number.replaceAll(".(?=.{4})", "*");
    }
}