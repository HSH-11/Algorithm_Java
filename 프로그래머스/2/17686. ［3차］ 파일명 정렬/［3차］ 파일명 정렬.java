import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, (a, b) -> {
            int aIndex = 0;
            int bIndex = 0;
            
            while (!Character.isDigit(a.charAt(aIndex))) {
                aIndex++;
            }
            
            while (!Character.isDigit(b.charAt(bIndex))) {
                bIndex++;
            }
            
            String aHead = a.substring(0, aIndex).toLowerCase();
            String bHead = b.substring(0, bIndex).toLowerCase();
            
            int result = aHead.compareTo(bHead);
            
            if (result != 0) {
                return result;
            }
            
            int aStart = aIndex;
            int bStart = bIndex;
            
            int acount = 0;
            int bcount = 0;

            while (aIndex < a.length() && Character.isDigit(a.charAt(aIndex)) && acount < 5) {
                aIndex++;
                acount++;
            }

            while (bIndex < b.length() && Character.isDigit(b.charAt(bIndex)) && bcount < 5) {
                bIndex++;
                bcount++;
            }

            int aNumber = Integer.parseInt(a.substring(aStart, aIndex));
            int bNumber = Integer.parseInt(b.substring(bStart, bIndex));
            
            return Integer.compare(aNumber, bNumber);
             
        });
        
       
        return files;
    }
}