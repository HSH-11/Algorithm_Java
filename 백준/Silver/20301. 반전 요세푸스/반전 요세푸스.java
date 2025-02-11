import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Deque<Integer> deque = new ArrayDeque<Integer>();

		for (int i = 1; i <= N; i++) {
			deque.offerLast(i);
		}

		boolean direction = true;
		int cnt = 0;
		while (!deque.isEmpty()) {
			if (cnt == M) {
				cnt = 0;
				direction = direction ? false : true; 
			}
			if (direction) {
				for (int i = 1; i <= K - 1; i++) {
					int num = deque.pollFirst();
					deque.offerLast(num);
				}
				sb.append(deque.pollFirst()).append("\n");
			}
			else {
				for (int i = 1; i <= K - 1; i++) {
					int num = deque.pollLast();
					deque.offerFirst(num);
				}
				sb.append(deque.pollLast()).append("\n");
				
			}
			cnt++;
		}
		System.out.println(sb.toString());

	}
}