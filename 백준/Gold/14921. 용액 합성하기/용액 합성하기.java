import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int minAbs = Integer.MAX_VALUE;

		int left = 0;
		int right = N - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			minAbs = (Math.abs(sum) < Math.abs(minAbs)) ? sum : minAbs; 
			
			if (sum > 0) {
				right--;
			}else if (sum < 0) {
				left++;
			}else {
				break;
			}
		}
		
		System.out.println(minAbs);
	}
}