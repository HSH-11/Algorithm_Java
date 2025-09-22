import java.io.*;
import java.util.*;

public class Main {
	static int T, K;
	static Deque<Integer>[] gears;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine()); // 톱니바퀴 수
		gears = new ArrayDeque[T + 1];

		// 초기 톱니바퀴 상태
		for (int i = 1; i <= T; i++) {
			String line = br.readLine();
			gears[i] = new ArrayDeque<>();
			for (char c : line.toCharArray()) {
				gears[i].offerLast(c - '0');
			}
		}

		K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); // 1: 시계 -1: 반시계

			// 톱니 회전 기록
			int[] rotateDir = new int[T + 1];
			rotateDir[idx] = dir;

			// 왼쪽부터
			for (int i = idx - 1; i >= 1; i--) {
				int right = getGearRight(i); // 오른쪽 톱니 (idx 2)
				int left = getGearLeft(i + 1);
				if (right != left) { // 극이 다르면 회전
					rotateDir[i] = -rotateDir[i + 1];
				} else
					break; // 같으면 더 이상 전파 X
			}

			// 오른쪽
			for (int i = idx + 1; i <= T; i++) {
				int left = getGearLeft(i); // i번 톱니 왼쪽(6번 index)
				int right = getGearRight(i - 1); // (i-1)번 톱니 오른쪽(2번 index)

				if (left != right) {
					rotateDir[i] = -rotateDir[i - 1];
				} else
					break;
			}

			// 실제 회전 실행
			for (int i = 1; i <= T; i++) {
				if (rotateDir[i] != 0) {
					rotate(gears[i], rotateDir[i]);
				}
			}

		}
		// 최종 결과: 12시 방향(첫 번째 값)이 S극(1)이면 카운트
		int ans = 0;
		for (int i = 1; i <= T; i++) {
			if (gears[i].peekFirst() == 1)
				ans++;
		}
		System.out.println(ans);
	}

	// 시계/반시계 회전
	static void rotate(Deque<Integer> gear, int dir) {
		if (dir == 1) { // 시계 방향
			gear.offerFirst(gear.pollLast());
		} else { // 반시계 방향
			gear.offerLast(gear.pollFirst());
		}
	}

	static int getGearRight(int i) {
		Iterator<Integer> it = gears[i].iterator();
		it.next(); // index 0
		it.next(); // index 1
		return it.next(); // index 2
	}

	static int getGearLeft(int i) {
		Iterator<Integer> it = gears[i].iterator();
		for (int j = 0; j < 6; j++)
			it.next();
		return it.next(); // index 6
	}
}
