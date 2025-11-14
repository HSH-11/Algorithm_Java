class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int healInterval = bandage[0];
        int basicHeal = bandage[1];
        int bonusHeal = bandage[2];

        int hp = maxHealth;
        int combo = 0;
        int currentTime = 0;

        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];

            // 회복 가능 시간
            int safeDuration = attackTime - currentTime - 1;

            // 안전 시간 동안 회복 수행
            for (int i = 0; i < safeDuration; i++) {
                // 기본 회복
                hp = Math.min(maxHealth, hp + basicHeal);
                combo++;

                // t초 연속 성공 시 추가 회복
                if (combo == healInterval) {
                    hp = Math.min(maxHealth, hp + bonusHeal);
                    combo = 0;
                }
            }

            // 공격 처리
            hp -= damage;
            if (hp <= 0) return -1;

            // 공격 받으면 연속 회복 초기화
            combo = 0;

            // 현재 시간 갱신
            currentTime = attackTime;
        }

        return hp;
    }
}
