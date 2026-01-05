class Solution {
    public long solution(int price, int money, int count) {
        long totalCost = 0;
        
        for (int i = 1; i <= count; i++) {
            totalCost += (long) price * i;
        }
        
        return money < totalCost ? totalCost - money : 0;
    }
}