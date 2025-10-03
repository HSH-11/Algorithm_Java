import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		int answer = 0;
		
		// 각 사람 i에 대해 2-친구 수 계산
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			for (int j = 0; j < N; j++) {
				if (i == j ) continue;
				if (arr[i].charAt(j) == 'Y') {
					visited[j] = true;
				}else {
					// 중간 k를 거쳐 친구인지 확인
					for (int k = 0; k < N; k++) {
						if (arr[i].charAt(k) == 'Y' && arr[k].charAt(j) == 'Y') {
							visited[j] = true;
							break;
						}
					}
				}
			}
			int cnt = 0;
            for (boolean v : visited) if (v) cnt++;
            answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}
}