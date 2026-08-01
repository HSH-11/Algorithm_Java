class Solution {
    
    final int[] rates = {10, 20, 30, 40};
    
    int[] answer = new int[2];
    int[] discounts;
    
    public int[] solution(int[][] users, int[] emoticons) {
    
        discounts = new int[emoticons.length];
        
        dfs(0, emoticons, users);
        
        return answer;
    }
    
    private void dfs(int depth, int[] emoticons, int[][] users) {
        
        if (depth == emoticons.length) {
            simulate(emoticons, users);       
            return;
        }
        
        for (int rate : rates) {
            discounts[depth] = rate;
            dfs(depth + 1, emoticons, users);
        }
        
    }
    
    private void simulate(int[] emoticons, int[][] users) {
        
        int subscriber = 0;
        int sales = 0;
        
        for (int[] user : users) {
            
            int minDiscount = user[0];
            int limit = user[1];
            int total = 0;
            
            for (int i = 0; i < emoticons.length; i++) {
                
                if (discounts[i] >= minDiscount) {
                    total += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }
            
            if (total >= limit) {
                subscriber++;
            } else {
              sales += total;  
            }
        }
        
        if (subscriber > answer[0] ||
                    (subscriber == answer[0] && sales > answer[1])) {

                    answer[0] = subscriber;
                    answer[1] = sales;
        }
    } 
}