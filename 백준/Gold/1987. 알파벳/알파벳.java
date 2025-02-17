import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static char[][] board;
	
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static boolean[] visited = new boolean[26];
	static int R,C,ans;
	

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    board = new char[R][C];
	    ans = 0;
	    for (int i = 0; i < R; i++) {
	        String line = br.readLine();
	        for (int j = 0; j < C; j++) {
	            	board[i][j] = line.charAt(j);               
	        }
	    }
	    
	    visited[board[0][0] - 'A'] = true;
	    dfs(0,0,1);
	    
	    System.out.println(ans);
	       
	}

	static void dfs(int y, int x, int count) {
	    ans = Math.max(ans, count);
	    
	    for (int i = 0; i < 4; i++) {
	    	int ny = y + dy[i];
	    	int nx = x + dx[i];
	    	
	    	if (nx >= 0 && ny >= 0 && ny < R && nx < C && !visited[board[ny][nx]-'A']) {   		
	    		visited[board[ny][nx]-'A'] = true;
	    		dfs(ny,nx,count+1);
	    		visited[board[ny][nx]-'A'] = false;
	    	
	    	}
	       		    	
	    }
	  
	}

}