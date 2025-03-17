import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의 종료 시간이 빠른 순서대로 정렬
//	-종료 시간이 같다면 시작 시간이 빠른 순서로 정렬
// 그리디: 회의가 끝나는 시간 이후에 시작하는 회의 중 가장 빨리 끝나는 회의를 선택

// 해결 방법
// 입력된 (시작시간, 종료시간) 쌍을 종료 시간 기준으로 오름차순 정렬
// 종료 시간이 같다면 시작 시간이 빠른 순서로 정렬(시작시간 기준 오름차순): 불필요한 간격 최소화
// 선택 후, 회의 종료 시간을 저장 
public class Main {

	static int N;
	static int meetings[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		meetings = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i][0] = start;
			meetings[i][1] = end;

		}

		Arrays.sort(meetings, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

		int count = 0;
		int lastEnd = 0;

		for (int[] meeting : meetings) {
			if (meeting[0] >= lastEnd) {
				lastEnd = meeting[1];
				count++;
			}
		}

		System.out.println(count);

	}

}