import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		Deque<int[]> deque = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());

			while (!deque.isEmpty() && deque.peekLast()[1] < height) {
				deque.pollLast();
			}
			sb.append(deque.isEmpty() ? "0 " : deque.peekLast()[0] + " ");
			deque.offerLast(new int[] { i, height });

		}
		System.out.println(sb.toString());
	}
}