import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

	static int N;
	static int[][] map;
	static int one,zero;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// map 초기화
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(0,0,N);
		System.out.println(zero);
		System.out.println(one);
		
	}

	static void check(int y, int x, int size) {
		int color = map[y][x];
		boolean flag = true;
		
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x+size; j++) {
				if (map[i][j] != color) {
					flag = false;
					break;
				}
			}
			if (!flag) break;
		}
		
		if (flag) {
			if (color == 1) one++;
			else zero++;
			return ;
		}
		
		int newsize = size / 2;
		check(y,x,newsize);
		check(y,x+newsize,newsize);
		check(y+newsize,x,newsize);
		check(y+newsize,x+newsize,newsize);
			
	}
}