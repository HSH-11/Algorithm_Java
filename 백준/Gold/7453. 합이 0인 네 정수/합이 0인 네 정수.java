import java.io.*;
import java.util.*;

public class Main {

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		// A+B 모든 합 저장
		int[] AB = new int[n * n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[idx++] = A[i] + B[j];
			}
		}
		
		// C+D 모든 합 저장
        int[] CD = new int[n * n];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                CD[idx++] = C[i] + D[j];
            }
        }
		
        Arrays.sort(AB);
        Arrays.sort(CD);

        long count = 0;
        int left = 0;
        int right = CD.length - 1;
        
        while (left < AB.length && right >= 0) {
            int sum = AB[left] + CD[right];

            if (sum == 0) {
                long abCount = 1;
                long cdCount = 1;
                left++;
                right--;

                // AB 중복 개수 세기
                while (left < AB.length && AB[left] == AB[left - 1]) {
                    abCount++;
                    left++;
                }

                // CD 중복 개수 세기
                while (right >= 0 && CD[right] == CD[right + 1]) {
                    cdCount++;
                    right--;
                }

                count += abCount * cdCount;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);

	}

}
