class Solution {
    static int r, c;
    public int solution(int[] mats, String[][] park) {
        r = park.length;
        c = park[0].length;
        int result = -1;
        for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++) {
        		for (int mat : mats) {
        			if (check(mat,i,j,park)) {
        				result = Math.max(result, mat);
        			} 
        		}
        	}
        }
        
    	
    	return result;
    }
    public static boolean check(int mat,int y, int x, String[][] park) {
    	boolean isEmpty = true;
    	for (int i = y; i < y + mat; i++) {
    		for (int j = x; j < x + mat; j++) {
    			if ( i >= r || j >= c || !park[i][j].equals("-1")) {
    				return false;
    			}
    		}
    	}
    	return isEmpty;
    } 
}