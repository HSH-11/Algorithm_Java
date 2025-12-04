class Solution {
    public int solution(String num_str) {
        int answer = 0;
        String[] a = num_str.split("");
        
        for(int i = 0; i < a.length; i++){
            answer += Integer.parseInt(a[i]);
        }
        return answer;
    }
}