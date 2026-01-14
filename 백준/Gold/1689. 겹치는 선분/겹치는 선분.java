import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lines = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lines[i][0] = s;
			lines[i][1] = e;
		}
		
		Arrays.sort(lines, (a,b) -> {
			if (a[0] == b[0]) return a[1] - b[1];
			return a[0] - b[0];
		});
		
		// 끝나는 지점 관리할 오름차순 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int maxOverlap = 0;
		
		for (int[] line : lines) {
			int s = line[0];
			int e = line[1];
			
			// 현재 선분의 시작점보다 일찍 또는 같게 끝나는 선분은 제거
			while(!pq.isEmpty() && pq.peek() <= s) {
				pq.poll();
			}
			
			pq.add(e);
			
			maxOverlap = Math.max(pq.size(), maxOverlap);
		}
		
		System.out.println(maxOverlap);
		
	
	}

}