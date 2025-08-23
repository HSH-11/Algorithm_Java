import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int next = 1; // 다음에 push할 수
		boolean ok = true;
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			while(next <= x) {
				stack.push(next++);
				sb.append("+\n");
			}
			
			// 맨 위가 x이면 pop, 아니면 불가능
			if (!stack.isEmpty() && stack.peek() == x) {
				stack.pop();
				sb.append("-\n");
			}else {
				ok = false;
				break;
			}
		}
		
		if (ok) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}

}