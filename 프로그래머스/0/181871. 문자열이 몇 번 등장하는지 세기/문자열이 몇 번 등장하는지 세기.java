class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        int patLength = pat.length();
        int myStringLength = myString.length();

        for (int i = myStringLength - 1; i >= 0; i--) {
            String substr = myString.substring(0, i + 1);
            if (substr.endsWith(pat)) {
                answer++;
            }
        }

        return answer;
    }
}