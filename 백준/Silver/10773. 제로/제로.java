import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		int answer = 0;
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				answer -= stack.pollLast();
				continue;
			}
			stack.offerLast(num);
			answer += num;
			
		}
		System.out.println(answer);
			
		
	}

}