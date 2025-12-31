class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; //26
        
        for (int i = 0; i < s.length(); i++) {
            int alphabet_index = s.charAt(i) - 'a';
            for (int j = 0; j < index; j++) {
                alphabet_index++;
                String str = Character.toString(alphabet.charAt(alphabet_index % 26));
                if (skip.contains(str)) {
                    j--;
                    continue;
                }
            }
            answer += alphabet.charAt(alphabet_index % 26);
        };
        return answer;
    }
}