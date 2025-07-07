import java.io.*;
import java.util.*;

public class Main {

	static long[] factorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		factorial = new long[N + 1];
		factorial[0] = 1;

		// 팩토리얼 0 ~ N까지 구해두기
		for (int i = 1; i <= N; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int mode = Integer.parseInt(st.nextToken());

		if (mode == 1) {
			long k = Long.parseLong(st.nextToken());
			boolean[] used = new boolean[N + 1];
			List<Integer> result = new ArrayList<Integer>();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (used[j])
						continue;

					if (factorial[N - i] < k) {
						k -= factorial[N - i];
					} else {
						result.add(j);
						used[j] = true;
						break;
					}
				}
			}

			for (int num : result) {
				System.out.printf(num + " ");
			}
		} else if (mode == 2) {
			int[] p = new int[N + 1];
			boolean[] used = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}

			long order = 1;
			for (int i = 1; i <= N; i++) {
				int count = 0;
				for (int j = 1; j < p[i]; j++) {
					if (!used[j])
						count++;
				}

				order += count * factorial[N - i];
				used[p[i]] = true;
			}

			System.out.println(order);
		}

	}

}
