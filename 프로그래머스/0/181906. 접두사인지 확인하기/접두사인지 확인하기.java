class Solution {
    public int solution(String my_string, String is_prefix) {
        int n = is_prefix.length();
        if (my_string.length() < n) return 0;
        
        if (my_string.substring(0,n).equals(is_prefix)) return 1;
        
        return 0;
    }
}