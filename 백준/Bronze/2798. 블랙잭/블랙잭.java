import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =  Integer.parseInt(st.nextToken());
		int tgt = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[i] = num;
		}
		int maxSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					int sum = nums[i]+nums[j]+nums[k];
					
					if (sum <= tgt && sum > maxSum) {
						maxSum = sum;
					}
					
				}
			}
		}
		System.out.println(maxSum);
		
	}
}