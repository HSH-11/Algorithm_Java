import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int A,B;
	static Queue<long[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		queue.offer(new long[] {A,1});
		
		while(!queue.isEmpty()) {
			long[] info = queue.poll();
			long num = info[0];
			long depth = info[1];
			
			if (num == B) {
				System.out.println(depth);
				return;
			}
			if (num * 2 <= B) {
				queue.offer(new long[] {num*2,depth+1});
			}
			if (num * 10 + 1 <= B) {
				queue.offer(new long[] {num*10+1,depth+1});
			}
		}
		
		System.out.println("-1");
		
	}
	
}