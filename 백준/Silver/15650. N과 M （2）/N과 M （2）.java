import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(0,1);

	}
	static void dfs(int depth, int start) {
		if (depth == M) {
			for (int num : arr) System.out.print(num + " ");
			System.out.println();
			return;
		}
		
		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(depth+1,i+1);
		}
	}
}