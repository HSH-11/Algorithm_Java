import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		while(deque.size()>1) {
			deque.pollFirst();
			int n1 = deque.pollFirst();
			deque.offerLast(n1);	
		}
		System.out.println(deque.poll());
			
	}

}