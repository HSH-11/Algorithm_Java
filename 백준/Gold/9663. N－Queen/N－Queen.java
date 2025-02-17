import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N,count;
	static int[] arr;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		nQueen(0);
		System.out.println(count);
			
	}
	
	static void nQueen(int y) {
		
		if (y == N) {
			count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[y] = i;
			if (check(y)) {
				nQueen(y+1);
			}
		}
	}
	
	static boolean check(int row) {
		for (int i = 0; i < row; i++) {
			if (arr[i] == arr[row]) {
				return false;
			}
			
			if(Math.abs(row-i) == Math.abs(arr[row]-arr[i])) {
				return false;
			}
		}
		return true;
	}

}