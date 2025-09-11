import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] switches = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int studentCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentCount; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				for (int j = num; j <= n; j += num) {
					switches[j] = 1 - switches[j];
				}
			} else {
				int left = num;
				int right = num;
				while (left > 1 && right < n && switches[left - 1] == switches[right + 1]) {
					left--;
					right++;
				}
				for (int j = left; j <= right; j++) {
					switches[j] = 1 - switches[j];
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }

	}
}
