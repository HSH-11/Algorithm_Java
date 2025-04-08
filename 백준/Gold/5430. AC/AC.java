import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
// 문제 조건
// R은 배열에 있는 수의 순서 뒤집기
// D는 첫 번째 수 버리기 (배열이 비어있는데 D를 사용하면 에러)
// 함수는 조합해서 한번만 사용

// 문제 해결
// Deque를 사용하자
// flag를 통해 순서를 뒤집은 효과를 만든다
// 1) R이면 reverse flag를 true
// 2-1) D일때 deque.isEmpty이면 error
// 2-2) !deque.isEmpty일 때 flag가 true이면 뒤에서 제거 false이면 앞에서 제거

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수
			String input = br.readLine();
			String parsing = input.substring(1,input.length()-1);
			
			// Deque에 정수 배열 저장
			Deque<Integer> deque = new ArrayDeque<Integer>();
			if (!parsing.isEmpty()) {
				for (String s : parsing.split(",")) {
					deque.add(Integer.parseInt(s));
				}
			}
			
			boolean reverse = false;
			boolean error = false; // deque이 빈 상태인지 확인 
			
			StringBuilder sb = new StringBuilder();
			for (char c : p.toCharArray()) {
				if (c == 'R') {
					reverse = !reverse;
				}else if ( c == 'D') {
					if (deque.isEmpty()) {
						error = true;
						break;
					}
					if (reverse) {
						deque.removeLast();
					}else {
						deque.removeFirst();
					}
				}
			}
			
			if (error) {
				sb.append("error");
			}else {
				sb.append("[");
				while(!deque.isEmpty()) {
					sb.append(reverse ? deque.removeLast() : deque.removeFirst());
					if(!deque.isEmpty()) {
						sb.append(",");
					}					
				}
				sb.append("]");
			}
			System.out.println(sb);
			
		}

	}

}