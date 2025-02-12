import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		int answer = 0;

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			int index = 0;

			for (int val : deque) {
				if (val == num)
					break;
				index++;
			}

			int left_move = index;
			int right_move = deque.size() - index;

			if (left_move <= right_move) {
				for (int j = 0; j < left_move; j++) {
					deque.addLast(deque.pollFirst());
				}
				answer += left_move;
			} else {
				for (int j = 0; j < right_move; j++) {
					deque.addFirst(deque.pollLast());
				}
				answer += right_move;
			}

			deque.pollFirst();
		}

		System.out.println(answer);

	}

}