class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int time = 1;
        int continuous = 0;
        
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];
            
            // 공격 전까지 회복
            while (time < attackTime) {
                if (hp < health) {
                    hp = Math.min(health, hp + x);   
                }
                
                continuous++;
                
                // 붕대 완성 회복
                if (continuous >= t) {
                    hp = Math.min(health, hp + y);
                    continuous = 0;
                }
                
                time++;
                  
            }
            hp -= damage;
            if (hp <= 0) return -1;
            
            continuous = 0;
            time++;
            
        }
        return hp;
    }
}