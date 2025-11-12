class Solution {
    public int solution(String myString, String pat) {
        String replacedString = myString.replace('A', 'X').replace('B', 'A').replace('X', 'B');
        
        return replacedString.contains(pat) ? 1 : 0;
       
    }
}