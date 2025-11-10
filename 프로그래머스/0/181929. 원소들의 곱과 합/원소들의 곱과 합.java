class Solution {
    public int solution(int[] num_list) {
        int multiply = 1;
        int sum = 0;
        for (int num : num_list) {
            multiply *= num;
            sum += num;
        }
        return (multiply < sum * sum) ? 1 : 0;
    }
}