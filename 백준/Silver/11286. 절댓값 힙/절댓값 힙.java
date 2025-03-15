import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 정수 범위 int
// 우선순위 큐의 비교 정의

public class Main {

	static int N;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<Integer>((a, b) -> {
			int A = Math.abs(a);
			int B = Math.abs(b);
			if (A == B) {
				return Integer.compare(a, b); // 절대값이 같다면 원래 값 비교
			}
			return Integer.compare(A, B);
		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			if (num == 0) {
				if (pq.isEmpty()) {
					sb.append("0\n");
				} else {
					int output = pq.poll();
					sb.append(output).append("\n");
				}
				continue;
			}

			pq.add(num);
		}
		
		System.out.println(sb);

	}

}