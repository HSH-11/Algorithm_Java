class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return min + " " + max;
    }
}