import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 1; i <= N; i++) {
        	deque.addLast(i);
        }
        bw.write("<");
        while(deque.size()> 1) {
        	for (int i = 0; i < K-1; i++) {
        		deque.addLast(deque.pollFirst());
        	}
        	bw.write(deque.pollFirst()+", ");
        }
        bw.write(deque.pollFirst()+">");
        bw.flush();
        bw.close();
        br.close();
        
        

	}
}