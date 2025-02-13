
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Deque<String> deque = new ArrayDeque<String>();
		
		for (int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");
			
			if(cmd[0].equals("push_front")) {
				deque.offerFirst(cmd[1]);
			}
			else if(cmd[0].equals("push_back")) { 
				deque.offerLast(cmd[1]);
			}
			else if(cmd[0].equals("pop_front")) {
				if (deque.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.pollFirst()).append("\n");
				}
			
			}else if(cmd[0].equals("pop_back")) {
				if (deque.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.pollLast()).append("\n");
				}
			}else if(cmd[0].equals("size")) {
				sb.append(deque.size()).append("\n");
			}else if(cmd[0].equals("empty")) {
				if (deque.isEmpty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}else if(cmd[0].equals("front")) {
				if (deque.isEmpty()) {
					sb.append("-1\n");
				}else {
				sb.append(deque.peekFirst()).append("\n");
				}
			}
			else if(cmd[0].equals("back")) {
				if (deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.peekLast()).append("\n");
				}
				
			}
			
		}
		System.out.println(sb.toString());
		
				
	}
		
}
