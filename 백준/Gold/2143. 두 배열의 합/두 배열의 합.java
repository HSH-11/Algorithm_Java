import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long T = Long.parseLong(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// 부분합 리스트 구하기
		List<Long> listA = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				listA.add(sum);
			}
		}

		List<Long> listB = new ArrayList<Long>();
		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				listB.add(sum);
			}
		}

		// 정렬
		Collections.sort(listA);
		Collections.sort(listB);

		int start = 0;
		int end = listB.size() - 1;
		long answer = 0;

		// 투포인터
		while (start < listA.size() && end >= 0) {
			long sum = listA.get(start) + listB.get(end);

			if (sum == T) {
				long aVal = listA.get(start);
				long bVal = listB.get(end);
				long cntA = 0, cntB = 0;

				while (start < listA.size() && listA.get(start) == aVal) {
					cntA++;
					start++;
				}

				while (end >= 0 && listB.get(end) == bVal) {
					cntB++;
					end--;
				}

				answer += cntA * cntB;
			} else if (sum < T) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(answer);
	}

}
