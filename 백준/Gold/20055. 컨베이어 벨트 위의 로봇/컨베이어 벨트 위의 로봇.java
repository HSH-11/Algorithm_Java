import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 조건
// N-1에 도달하면 로봇은 무조건 내린다
// 로봇은 앞칸에 로봇이 없고 내구도가 1 이상이면 한 칸 이동할 수 있다.
// 내구도가 0인 칸이 K개 이상이면 종료

// 문제 해결
// 벨트가 회전하고 로봇은 그 위에 움직이는 척을 한다.
// 로봇 위치 저장 배열
// 벨트 회전
//	-벨트,로봇 오른쪽으로 shift (맨 뒤는 앞으로)
//  -로봇도 함께 이동, N-1에 도착 로봇 제거
// 로봇 이동
// -뒤에서부터 확인하면서 한 칸 앞으로 이동 조건 체크
// 처음 위치에 올릴 수 있으면 올림
// 종료: 내구도 0의 칸 K개 이상

//언어 : JAVA , (성공/실패) : 1/0 , 메모리 : 22596 KB , 시간 : 392ms

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] belt = new int[N * 2 + 1];
		boolean[] robots = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N * 2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int step = 1;
		
		// 로봇을 옮기는 과정
		while (true) {
			// 1. 벨트 + 로봇 회전
			int temp = belt[N*2];
			// 로봇도 함께 회전
			for (int i = N * 2; i > 1; i--) {
				belt[i] = belt[i - 1];
			}
			
			belt[1] = temp;
			
			//로봇의 위치를 한칸씩 옮긴다.
            for (int i = N; i > 1; i--) {
                robots[i] = robots[i-1];
            }

            robots[1] = false;

            //내리는 위치에 로봇이 있으면 내린다.
            if(robots[N]) {
                robots[N] = false;
            }
			// 2. 로봇 이동
			for (int i = N - 1; i > 0; i--) {
				if (robots[i] && !robots[i+1] && belt[i+1] >= 1) {
                    belt[i+1]--;
                    robots[i] = false;
                    robots[i+1] = true;
                }
            }

            //내리는 위치에 로봇이 있으면 내린다.
            if(robots[N]) {
                robots[N] = false;
            }


			// 3번: 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (belt[1] > 0) {
				robots[1] = true;
				belt[1]--;
			}

			// 4번: 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
			 int zeroCount = 0;
	            for (int i = 1; i<= N * 2; i++) {
	                if (belt[i] == 0) zeroCount++;
	            }
	            if (zeroCount >= K) {
	                System.out.println(step);
	                break;
	            }

	            step++;
		}
	}

}