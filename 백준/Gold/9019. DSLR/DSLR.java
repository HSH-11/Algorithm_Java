import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// D는 n을 2배로 if(결과값이 9999보다 큰 경우에는 10000으로 나눈 나머지를 취한다)
// S는 n에서 1을 뺀 결과 n-1을 레지스터에 저장 n이 0이면 9999가 대신 레지스터에 저장
// L은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장. 이 연산이 d2,d3,d4,d1이 됨
// R은 오른쪽으로 회전
// 목표: 서로 다른 두 정수 A와B에대하여 A를 B로 바꾸는 최소한의 명령어
// bfs 최소경로 보장
public class Main {

	static class State {
		int num;
		String cmd;

		public State(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}

	static int D(int n) {
		return (n * 2) % 10000;
	}

	static int S(int n) {
		return (n == 0) ? 9999 : n - 1;
	}

	static int L(int n) {
		return (n % 1000) * 10 + n / 1000;
	}

	static int R(int n) {
		return (n % 10) * 1000 + (n / 10);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			Queue<State> queue = new ArrayDeque<Main.State>();
			boolean[] visited = new boolean[10000];

			queue.offer(new State(A, ""));
			visited[A] = true;

			while (!queue.isEmpty()) {
				State cur = queue.poll();
				int num = cur.num;
				String cmd = cur.cmd;

				if (num == B) {
					bw.write(cmd + "\n");
					break;
				}

				int[] nextNums = { D(num), S(num), L(num), R(num) };
				char[] command = { 'D', 'S', 'L', 'R' };

				for (int i = 0; i < 4; i++) {
					if (!visited[nextNums[i]]) {
						visited[nextNums[i]] = true;
						queue.offer(new State(nextNums[i], cmd + command[i]));
					}
				}
			}

		}
		bw.flush();
        bw.close();
	}

}