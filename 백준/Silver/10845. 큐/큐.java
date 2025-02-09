import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();

		StringBuilder sb= new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			if(cmd.startsWith("push")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);
				queue.offerLast(x);
			}
			else if(cmd.equals("pop")) {
				sb.append(queue.isEmpty() ? -1 :queue.pollFirst()).append("\n");
			}
			else if(cmd.equals("front")) {
				sb.append(queue.isEmpty() ? -1 :queue.peekFirst()).append("\n");
			}
			else if(cmd.equals("back")) {
				sb.append(queue.isEmpty() ? -1 :queue.peekLast()).append("\n");
			}
			else if(cmd.equals("size")) {
				sb.append(queue.size()).append("\n");
			}
			else if(cmd.equals("empty")) {
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
			}
			
		}
		System.out.println(sb);
	}

}