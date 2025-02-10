import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//비트 마스크 활용 (집합에 포함된 요소가 적을 때 hashset보다 유리)
public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int set = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			String cmd = br.readLine();
			
			if (cmd.startsWith("add")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);
				set |= (1 << (x-1));
			}
			else if(cmd.startsWith("remove")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);
				set &= ~(1 << (x-1));
			}
			else if(cmd.startsWith("check")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);
				
				if ((set & (1 << (x-1))) != 0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
			else if(cmd.startsWith("toggle")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);
				
				if ((set & (1 << (x-1))) != 0) {
					set &= ~(1 << (x-1));
				}else {
					set |= (1 << (x-1));
				}			
			}
			else if(cmd.equals("all")) {
				set = (1 << 20) - 1; // 21번째 비트만 1인 상태에서 1을 빼면 20개 비트가 1로 변경
			}
			else if(cmd.equals("empty")) {
				set = 0;
			}
		}
		System.out.println(sb.toString());
				
	}
		
}