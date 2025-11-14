class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        int idx = 0;
        for (int[] part : parts) {
            int s = part[0];
            int e = part[1];
            answer += my_strings[idx].substring(s,e+1);
            idx++;
        }
        return answer;
    }
}