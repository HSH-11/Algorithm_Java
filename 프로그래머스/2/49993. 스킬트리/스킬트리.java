class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            int index = 0;
            boolean possible = true;
            
            for (int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);
                int order = skill.indexOf(c);
                
                if (order == -1) {
                    continue;
                }
                
                // 다음에 배워야 할 스킬과 다르면 불가능
                if (order != index) {
                    possible = false;
                    break;
                }
                
                index++;
            }
            
            if (possible) {
                answer++;
            }
        }
        
        return answer;
    }
}