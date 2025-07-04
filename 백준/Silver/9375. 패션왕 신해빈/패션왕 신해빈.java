import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		while( T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			Map<String,Integer> map = new HashMap<String, Integer>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				
				map.put(type, map.getOrDefault(type, 0)+1);
			}
			
			int answer = 1;
			for (int count : map.values()) {
				answer *= (count + 1); // 안 입는 선택 포함
			}
			
			answer -= 1; // 아무것도 안 입는 경우 제거
			
			System.out.println(answer);
		}
		
		
	}

}