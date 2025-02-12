import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
       
        Arrays.sort(people); 
        int count = 0; 
        int i = 0; 
        int j = people.length - 1; 
        
        
        while( i <= j ) {
                       
            if( people[i] + people[j] <= limit ) {
                i++; 
            }
            
            j--;
            count++;
        }
        return count;
    }
}