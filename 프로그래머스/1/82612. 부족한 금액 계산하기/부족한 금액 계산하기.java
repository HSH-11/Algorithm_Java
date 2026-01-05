class Solution {
    public long solution(int price, int money, int count) {
        long totalCost = 0;
           
        totalCost = (long)price * count * (count + 1) / 2;
                
        return money < totalCost ? totalCost - money : 0;
    }
}
