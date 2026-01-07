import java.util.Arrays;

class Solution {
    public String solution(String s) {
        // 문자열을 문자 배열(char[])로 변환
        char[] chars = s.toCharArray();
        
        // 오름차순 정렬
        Arrays.sort(chars);
        
        // StringBuilder를 이용해 뒤집기
        return new StringBuilder(new String(chars)).reverse().toString();
    }
}