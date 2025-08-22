import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[10];
		int left = 0, kind = 0, maxLen = 0;

		for (int right = 0; right < N; right++) {
			if (cnt[arr[right]]++ == 0)
				kind++;
			while (kind > 2) {
				if (--cnt[arr[left]] == 0)
					kind--;
				left++;
			}
			maxLen = Math.max(maxLen, right - left + 1);
		}
		System.out.println(maxLen);
	}

}