import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS = new int[N]; // 각 위치를 기준으로 왼쪽에서 끝나는 최장 증가 부분 수열 길이 
		int[] LDS = new int[N]; // 각 위치를 기준으로 오른쪽에서 시작하는 최장 감소 부분 수열 길이
		
		// LIS
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		
		// LDS
		for (int i = N - 1; i >=0; i--) {
			LDS[i] = 1;
			for (int j = N -1; j > i; j--) {
				if (A[j] < A[i] && LDS[i] < LDS[j] + 1) {
					LDS[i] = LDS[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int length = LIS[i] + LDS[i] - 1;
			max = length > max ? length : max;
		}
		System.out.println(max);
	}

}