import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> Heap = new PriorityQueue<Integer>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				if (Heap.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(Heap.poll()).append("\n");
				}
			}else {
				Heap.add(x);
			}
		}
		System.out.print(sb.toString());
	}

}