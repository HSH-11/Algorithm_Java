import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr =  new int[N+1];
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i >= 1; i--) {
			if (K == 0) break;
			if (arr[i] <= K) {
				count += K / arr[i];
				K -= arr[i] * (K / arr[i]);
			}
		}
		System.out.println(count);
	
	}
}