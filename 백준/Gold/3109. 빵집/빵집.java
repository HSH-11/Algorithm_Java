import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static int[] dy = {-1,0,1}; 
	static int R,C,count;
	

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    map = new char[R][C];

	    for (int i = 0; i < R; i++) {
	        String line = br.readLine();
	        for (int j = 0; j < C; j++) {
	            	map[i][j] = line.charAt(j);               
	        }
	    }
	    
	    count = 0;
	    for (int i = 0; i < R; i++) {
	    	if(dfs(i, 0)) {
	    		count++;
	    	}
	    }
	    
	    System.out.println(count);
	       
	}

	static boolean dfs(int y, int x) {
	    
		if (x == C - 1) return true; 

	    for (int i = 0; i < 3; i++) {
	    	int ny = y + dy[i];
	    	int nx = x + 1;
	    	
	    	if (ny >= 0 && ny < R && nx < C && map[ny][nx] == '.') {
	    		map[ny][nx] = 'x';
	    		if(dfs(ny, nx)) {
	    			return true;
	    		}
	    	}
	    		
	    	
	    }
	    return false;
	}

}