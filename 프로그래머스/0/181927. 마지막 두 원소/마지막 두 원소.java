import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        int num_list_len = num_list.length;
        
        int Num1 = num_list[num_list_len-1];
        int Num2 = num_list[num_list_len-2];

        int[] resultArray = Arrays.copyOf(num_list, num_list_len + 1);
        
        resultArray[resultArray.length-1] = Num1 > Num2 ? Num1 - Num2 : Num1 * 2;
        
        return resultArray;
    }
}