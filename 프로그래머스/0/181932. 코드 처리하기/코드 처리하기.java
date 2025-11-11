class Solution {
    public String solution(String code) {
        String answer = "";
        boolean mode = true;
        
        for (int i = 0; i < code.length(); i++) {
            if (mode) {
                if (code.charAt(i) != '1') {
                    if (i % 2 == 0){
                        answer += String.valueOf(code.charAt(i));
                    }
                }else {
                    mode = !mode;
                }
                
            }else {
                if (code.charAt(i) != '1') {
                    if (i % 2 == 1){
                        answer += String.valueOf(code.charAt(i));
                    }
                }else {
                    mode = !mode;
                }
            }
        }
        
        
        return (answer == "") ? "EMPTY" : answer;
    }
}